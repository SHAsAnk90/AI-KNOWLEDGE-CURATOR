from fastapi import FastAPI
from app.routers.process_router import router as process_router
app = FastAPI()

app.include_router(process_router)


@app.get("/")
def home():
    return {"message": "Welcome to the AI Service!"}