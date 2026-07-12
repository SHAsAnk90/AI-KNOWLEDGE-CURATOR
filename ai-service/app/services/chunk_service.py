from app.models.lecture_context import LectureContext

class ChunkService:

    MAX_CHUNK_SIZE = 2000

    @staticmethod
    def process(context: LectureContext):
        transcript = context.transcript
        if not transcript:
            return
        
        paragraphs = transcript.split("\n\n")
        current_chunk = ""
        chunks = []
        for paragraph in paragraphs:
            paragraph = paragraph.strip()
            if not paragraph:
                continue
            if len(current_chunk) + len(paragraph) <= ChunkService.MAX_CHUNK_SIZE:
                if current_chunk:
                    current_chunk += "\n\n"
                
                current_chunk += paragraph
            else:
                chunks.append(current_chunk)
                current_chunk = paragraph
        if current_chunk:
            chunks.append(current_chunk)

        context.chunks = chunks