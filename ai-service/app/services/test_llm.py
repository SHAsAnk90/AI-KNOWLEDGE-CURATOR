from app.services.llm_service import LLMService
llm = LLMService()
response = llm.generate("Write a short poem about the beauty of nature.")
print(response)