package com.aiKnowledgecurator.backend.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.File;
import com.aiKnowledgecurator.backend.config.AppProperties;
import java.util.UUID;

@Service
public class VedioDownloadService {
     
     AppProperties appProperties;
     public VedioDownloadService(AppProperties appProperties) {
          this.appProperties = appProperties;
     }

    public File downloadVedio(String youtubeUrl) throws IOException, InterruptedException {
        String uniqueId = UUID.randomUUID().toString();
        File requestFolder = new File(appProperties.getDownloadDirectory(), uniqueId);
        if (!requestFolder.exists()) {
            requestFolder.mkdirs();
        }

        String outputTemplate = requestFolder.getAbsolutePath()+File.separator+"/%(title)s.%(ext)s";
        ProcessBuilder processBuilder = new ProcessBuilder(
                "yt-dlp", "-o", outputTemplate, youtubeUrl
        );

          Process process = processBuilder.start();

        String output = new String(process.getInputStream().readAllBytes());

        int exitCode = process.waitFor();

        System.out.println("===== yt-dlp Output =====");
        System.out.println(output);
        System.out.println("=========================");
        System.out.println("Exit Code: " + exitCode);

        if (exitCode != 0) {
            throw new IOException("Failed to download video.\n" + output);
        }

        File[] files = requestFolder.listFiles();

        if (files != null && files.length > 0) {
            return files[0];
        }

        throw new IOException("No video file found after download.");
    }
        
    }

