import whisper
from app.models.lecture_context import LectureContext

class TranscriptionService:

    def  __init__(self):
        self.model = whisper.load_model("base")

    def process(self, context: LectureContext):
        result = self.model.transcribe(context.audio_path)
        context.transcript = result["text"]