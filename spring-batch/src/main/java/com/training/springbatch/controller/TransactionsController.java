package com.training.springbatch.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job processTransactionsJob;

    @GetMapping("/process")
    public ResponseEntity<String> launchJob() {


        try {
            JobExecution jobExecution = jobLauncher.run(processTransactionsJob, new JobParameters());
            return ResponseEntity.ok("Job Status: " + jobExecution.getStatus());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error launching job: " + e.getMessage());
        }
    }
}

