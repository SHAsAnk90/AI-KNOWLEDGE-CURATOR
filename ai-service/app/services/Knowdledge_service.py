from pathlib import Path
from app.services.llm_service import LLMService
from app.models.lecture_context import LectureContext

class KnowledgeService:
    
    def __init__(self):
        self.llm_service = LLMService()

    def generate_summary(self, context: LectureContext) -> str:
        prompt_path = Path("app/prompts/Knowledge_prompt.txt")
        with open(prompt_path, "r", encoding="utf-8") as file:
            prompt_template = file.read()
            if not context.chunks:
                return
            chunk = context.chunks[0]
        
        final_prompt = f"""{prompt_template}
                       Lecture Transcript: 
                       
                       {chunk}""" 
        response = self.llm_service.generate(final_prompt)
        context.knowledge_tree = response
        print(response)