package com.aiKnowledgecurator.backend.controller;


import org.springframework.web.bind.annotation.*;
import com.aiKnowledgecurator.backend.dto.GenerateNotesRequest;
import com.aiKnowledgecurator.backend.dto.GenerateNotesResponse;
import com.aiKnowledgecurator.backend.service.GenerateNotesService;


@RestController
@RequestMapping("/api/v1")
public class NotesController {

    private final GenerateNotesService generateNotesService;

    public NotesController(GenerateNotesService generateNotesService) {
        this.generateNotesService = generateNotesService;
    }

    @PostMapping("/generate-notes")
    public GenerateNotesResponse generateNotes(@RequestBody GenerateNotesRequest request) {
        return generateNotesService.generateNotes(request);
    }

}
