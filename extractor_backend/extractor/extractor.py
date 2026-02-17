from typing import List, Optional
import yt_dlp
from .models import Video
from utils.logger import logger
from datetime import datetime, timezone


class Extractor:
    def __init__(self):
        self._cache = {}
        self._search_cache = {}
        self._profile_cache = {}
        self._search_opts = {
            "quiet": True,
            "extract_flat": True,
            "force_generic_extractor": False,
            "noplaylist": True,
            "socket_timeout": 10,
            "retries": 2,
            "nocheckcertificate": True,
        }

    def search_page(self, query: str, page: int, page_size: int = 20) -> List[Video]:
        if page < 1:
            page = 1

        cache_key = (query, page)
        if cache_key in self._search_cache:
            return self._search_cache[cache_key]

        limit = page * page_size
        start_index = (page - 1) * page_size

        logger.info(f"Buscando pagina {page} para '{query}' (fetch limit: {limit})")

        opts = self._search_opts.copy()
        url = f"ytsearch{limit}:{query}"

        try:
            with yt_dlp.YoutubeDL(opts) as ydl:
                info = ydl.extract_info(url, download=False)
        except Exception as e:
            logger.error(f"Error yt-dlp search: {e}")
            return []

        try:
            results = []
            if isinstance(info, dict) and "entries" in info:
                entries = info.get("entries") or []
                page_entries = entries[start_index:limit]

                for entry in page_entries:
                    if not entry:
                        continue
                    try:
                        video_url = entry.get("url") or ""
                        if video_url and not video_url.startswith("http"):
                            video_url = f"https://www.youtube.com/watch?v={video_url}"
                        ts = entry.get("timestamp")
                        age_text = ""
                        if ts:
                            try:
                                dt = datetime.fromtimestamp(ts, tz=timezone.utc)
                                diff = datetime.now(tz=timezone.utc) - dt
                                days = diff.days
                                seconds = diff.seconds
                                if days >= 365:
                                    years = days // 365
                                    age_text = f"hace {years} año{'s' if years!=1 else ''}"
                                elif days >= 30:
                                    months = days // 30
                                    age_text = f"hace {months} mes{'es' if months!=1 else ''}"
                                elif days >= 1:
                                    age_text = f"hace {days} día{'s' if days!=1 else ''}"
                                else:
                                    hours = seconds // 3600
                                    if hours >= 1:
                                        age_text = (
                                            f"hace {hours} hora{'s' if hours!=1 else ''}"
                                        )
                                    else:
                                        mins = seconds // 60
                                        age_text = (
                                            f"hace {mins} minuto{'s' if mins!=1 else ''}"
                                        )
                            except Exception:
                                age_text = ""
                        uploader_url = (
                            entry.get("channel_url") or entry.get("uploader_url") or ""
                        )
                        try:
                            views = int(entry.get("view_count") or 0)
                        except Exception:
                            views = 0
                        avatar_url = entry.get("channel_thumbnail") or ""
                        v = Video(
                            id=entry.get("id") or "",
                            title=entry.get("title", "Sin titulo"),
                            url=video_url,
                            uploader=entry.get("uploader", "Desconocido"),
                            duration=int(entry.get("duration") or 0),
                            thumbnail_url=entry.get("thumbnail", "")
                            or (
                                f"https://img.youtube.com/vi/{entry.get('id')}/mqdefault.jpg"
                                if entry.get("id")
                                else ""
                            ),
                            views=views,
                            age_text=age_text,
                            uploader_url=uploader_url,
                            uploader_avatar_url=avatar_url,
                        )
                        results.append(v)
                    except Exception as e:
                        logger.error(f"Entry parse error: {e}")
                        continue

            self._search_cache[cache_key] = results
            return results
        except Exception as e:
            logger.error(f"Error en busqueda paginada: {e}")
            return []

    def search(self, query, limit=20):
        return self.search_page(query, 1, page_size=limit)

    def get_stream(
        self, video_url: str, quality: str = "1080p", profile: str = "balanced"
    ) -> dict:
        if not profile:
            profile = "balanced"

        cache_key = (video_url, quality, profile)
        if cache_key in self._cache:
            logger.info(f"Stream (Cached) encontrado para {video_url} [{profile}]")
            return self._cache[cache_key]

        logger.info(
            f"Extrayendo stream para {video_url} | Calidad: {quality} | Perfil: {profile}"
        )

        user_height_map = {
            "4K": 2160,
            "2K": 1440,
            "1440p": 1440,
            "1080p": 1080,
            "720p": 720,
            "480p": 480,
            "360p": 360,
        }
        target_height = user_height_map.get(quality, 1080)

        if profile == "low":
            max_h = min(target_height, 1080)
            fmt = (
                f"best[ext=mp4][vcodec^=avc1][height<={max_h}]/"
                f"bestvideo[vcodec^=avc1][height<={max_h}]+bestaudio[acodec^=mp4a]/"
                f"best[height<={max_h}]"
            )
        elif profile == "balanced":
            max_h = min(target_height, 1440)
            fmt = (
                f"best[ext=mp4][height<={max_h}]/"
                f"bestvideo[height<={max_h}]+bestaudio/"
                f"best[height<={max_h}]"
            )
        else:
            max_h = target_height
            fmt = "bestvideo+bestaudio/best"

        opts = {
            "format": fmt,
            "quiet": True,
            "noplaylist": True,
            "socket_timeout": 30,
            "retries": 5,
            "nocheckcertificate": True,
            "no_warnings": True,
            "ignoreerrors": False,
        }

        stream_info = {"url": None, "audio_url": None}

        try:
            with yt_dlp.YoutubeDL(opts) as ydl:
                logger.debug(f"yt-dlp format selector: {fmt}")

                try:
                    info = ydl.extract_info(video_url, download=False)
                except Exception as e:
                    logger.warning(
                        f"Extracción estándar falló, intentando modo rápido: {e}"
                    )
                    opts["socket_timeout"] = 60
                    with yt_dlp.YoutubeDL(opts) as ydl2:
                        info = ydl2.extract_info(video_url, download=False)

                if "requested_formats" in info:
                    for f in info["requested_formats"]:
                        if f.get("vcodec") != "none":
                            stream_info["url"] = f.get("url")
                        elif f.get("acodec") != "none":
                            stream_info["audio_url"] = f.get("url")
                else:
                    stream_info["url"] = info.get("url")

                if stream_info["url"]:
                    logger.info("Stream extraido exitosamente.")
                    self._cache[cache_key] = stream_info
                else:
                    logger.warning("No se encontro URL directa valida.")

        except Exception as e:
            logger.error(f"Error extrayendo stream: {e}")

        return stream_info

    def get_channel_avatar_url(self, channel_url: str) -> Optional[str]:
        if not channel_url:
            return None
        if channel_url in self._profile_cache:
            return self._profile_cache[channel_url]
        try:
            opts = {
                "quiet": True,
                "skip_download": True,
                "extract_flat": False,
                "noplaylist": True,
                "nocheckcertificate": True,
            }
            with yt_dlp.YoutubeDL(opts) as ydl:
                info = ydl.extract_info(channel_url, download=False)
            thumb = None
            try:
                if isinstance(info, dict):
                    thumb = info.get("thumbnail")
                    if not thumb and "thumbnails" in info:
                        thumbs = info.get("thumbnails") or []
                        if thumbs:
                            thumb = thumbs[0].get("url")
            except Exception:
                thumb = None
            if thumb:
                self._profile_cache[channel_url] = thumb
            return thumb
        except Exception as e:
            logger.error(f"Avatar channel fetch error: {e}")
            return None

