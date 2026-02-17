from fastapi import FastAPI, Query
from extractor.extractor import Extractor


app = FastAPI()
extractor = Extractor()


@app.get("/search")
def search(q: str = Query(...), page: int = 1, page_size: int = 20):
    videos = extractor.search_page(q, page, page_size)
    return [
        {
            "id": v.id,
            "title": v.title,
            "url": v.url,
            "uploader": v.uploader,
            "duration": v.duration,
            "thumbnail_url": v.thumbnail_url,
            "views": v.views,
            "age_text": v.age_text,
            "uploader_url": v.uploader_url,
            "uploader_avatar_url": v.uploader_avatar_url,
        }
        for v in videos
    ]


@app.get("/stream")
def stream(url: str, quality: str = "1080p", profile: str = "balanced"):
    info = extractor.get_stream(url, quality, profile)
    return {
        "url": info.get("url"),
        "audio_url": info.get("audio_url"),
        "hls": None,
    }

