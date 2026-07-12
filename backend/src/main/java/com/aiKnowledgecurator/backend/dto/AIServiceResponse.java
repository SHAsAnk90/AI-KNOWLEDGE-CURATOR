package com.aiKnowledgecurator.backend.dto;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AIServiceResponse {
    public String message;
    public String status;
    public AIServiceResponse() {
        this.message = "success";
        this.status = "success";
    }
}
