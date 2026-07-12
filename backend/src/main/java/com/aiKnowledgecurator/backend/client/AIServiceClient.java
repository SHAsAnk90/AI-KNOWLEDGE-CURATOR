package com.aiKnowledgecurator.backend.client;

import com.aiKnowledgecurator.backend.dto.AIServiceResponse;
import com.aiKnowledgecurator.backend.config.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.util.*;

import java.io.File;

@Component
public class AIServiceClient {

    private final AppProperties appProperties;
    private final RestClient restClient;

    public AIServiceClient(AppProperties appProperties, RestClient restClient) {
        this.appProperties = appProperties;
        this.restClient = restClient;
    }

    public AIServiceResponse sendFileToAIService(File file) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(file));
        return restClient.post()
                .uri(appProperties.getAiServiceBaseUrl() + "/api/v1/process")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(body)
                .retrieve()
                .body(AIServiceResponse.class);
    }

}
