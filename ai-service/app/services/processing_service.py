from app.services.audio_service import AudioService
from app.services.transcription_service import TranscriptionService
from app.models.lecture_context import LectureContext
from app.services.chunk_service import ChunkService


class ProcessingService:
    
    def __init__(self):
        self.audio_service = AudioService()
        self.transcription_service = TranscriptionService()
        self.chunk_service = ChunkService()

    def process(self, video_path: str) -> str:
        context = LectureContext(video_path=video_path)
        self.audio_service.process(context)
        self.transcription_service.process(context)
        self.chunk_service.process(context)
        return context