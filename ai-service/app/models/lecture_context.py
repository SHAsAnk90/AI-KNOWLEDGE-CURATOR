from dataclasses import dataclass, field

@dataclass
class LectureContext:

    video_path: str
    audio_path: str | None = None
    transcript: str | None = None
    chunks: list[str] = field(default_factory=list)
    knowledge_tree: dict = field(default_factory=dict)
    markdown_notes: str | None = None