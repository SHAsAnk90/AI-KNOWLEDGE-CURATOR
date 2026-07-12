package com.aiKnowledgecurator.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${app.ai.base-url}")
    private String aiServiceBaseUrl;


     @Value("${app.download.directory}")
     private String downloadDirectory;

     public String getDownloadDirectory() {
         return downloadDirectory;
     }
     public String getAiServiceBaseUrl() {
         return aiServiceBaseUrl;
     }

}
