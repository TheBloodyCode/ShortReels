from dataclasses import dataclass


@dataclass
class Video:
    id: str
    title: str
    url: str
    uploader: str
    duration: int
    thumbnail_url: str
    views: int
    age_text: str
    uploader_url: str
    uploader_avatar_url: str

