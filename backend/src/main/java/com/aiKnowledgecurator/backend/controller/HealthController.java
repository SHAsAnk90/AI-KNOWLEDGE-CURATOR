package com.aiKnowledgecurator.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HealthController {
   @GetMapping("/health")
   public String health()
   {
    return "Backend is up and running";
   }
   
}
