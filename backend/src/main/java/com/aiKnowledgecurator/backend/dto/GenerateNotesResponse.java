package com.aiKnowledgecurator.backend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.io.File;

@Data
@AllArgsConstructor
public class GenerateNotesResponse {
    private String notes;
    private File path;
}
