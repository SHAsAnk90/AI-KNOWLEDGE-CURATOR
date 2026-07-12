import subprocess
from pathlib import Path

from app.models.lecture_context import LectureContext

class AudioService:

     @staticmethod
     def process(context: LectureContext):

        video = Path(context.video_path)

        audio_path = Path("temp") / f"{video.stem}.wav"

        command = [
            "ffmpeg",
            "-y",
            "-i",
            str(video),
            "-vn",
            "-acodec",
            "pcm_s16le",
            "-ar",
            "16000",
            "-ac",
            "1",
            str(audio_path)
        ]

        subprocess.run(
            command,
            check=True
        )

        context.audio_path = str(audio_path)