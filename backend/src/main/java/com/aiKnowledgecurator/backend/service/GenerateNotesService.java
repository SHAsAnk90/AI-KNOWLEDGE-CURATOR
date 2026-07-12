package com.aiKnowledgecurator.backend.service;


import org.springframework.stereotype.Service;
import com.aiKnowledgecurator.backend.dto.GenerateNotesRequest;
import com.aiKnowledgecurator.backend.dto.GenerateNotesResponse;
import com.aiKnowledgecurator.backend.client.AIServiceClient;
import com.aiKnowledgecurator.backend.dto.AIServiceResponse;
import java.io.File;

@Service
public class GenerateNotesService {
   
    private final VedioDownloadService vedioDownloaderService;
    private final AIServiceClient aiServiceClient;

    public GenerateNotesService(VedioDownloadService vedioDownloaderService, AIServiceClient aiServiceClient) {
        this.vedioDownloaderService = vedioDownloaderService;
        this.aiServiceClient = aiServiceClient;
    }

    public GenerateNotesResponse generateNotes(GenerateNotesRequest request) {
          try
          {
                File vedio = vedioDownloaderService.downloadVedio(request.getYoutubeUrl());
                AIServiceResponse aiResponse = aiServiceClient.sendFileToAIService(vedio);
                return new GenerateNotesResponse(aiResponse.getMessage(), vedio);
            }
            catch (Exception e) {
                return new GenerateNotesResponse("error: " + e.getMessage(), null);
            }
    }
}
