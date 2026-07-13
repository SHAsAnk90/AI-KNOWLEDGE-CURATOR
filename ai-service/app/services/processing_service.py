from app.services.audio_service import AudioService
from app.services.transcription_service import TranscriptionService
from app.models.lecture_context import LectureContext
from app.services.chunk_service import ChunkService
from app.services.Knowdledge_service import KnowledgeService


class ProcessingService:
    
    def __init__(self):
        self.audio_service = AudioService()
        self.transcription_service = TranscriptionService()
        self.chunk_service = ChunkService()
        self.knowledge_service = KnowledgeService()

    def process(self, video_path: str) -> str:
        context = LectureContext(video_path=video_path)
        self.audio_service.process(context)
        print("Audio extraction completed.")
        self.transcription_service.process(context)
        print("Transcription completed.")
        self.chunk_service.process(context)
        print("Chunking completed.")
        KnowledgeService().generate_summary(context)
        print("Knowledge summary generated.")
        return context