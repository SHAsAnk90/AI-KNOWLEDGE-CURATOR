from fastapi import APIRouter, UploadFile, File
from pathlib import Path
import shutil

from app.services.processing_service import ProcessingService

router = APIRouter(prefix = "/api/v1", tags = ["AI Process"])

processing_service = ProcessingService()

@router.post("/process")
async def process_vedio(file: UploadFile = File(...)):
    upload_path = Path("uploads") / file.filename
    with open(upload_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    context = processing_service.process(str(upload_path))
    print(context.knowledge_tree)
    return {"message": "Video processed successfully", "transcript": context.chunks}
