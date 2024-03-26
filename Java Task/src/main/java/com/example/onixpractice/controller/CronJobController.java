package com.example.onixpractice.controller;

import com.example.onixpractice.model.CronJob;
import com.example.onixpractice.services.CronJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cron-jobs")
public class CronJobController {

    @Autowired
    private CronJobService cronJobService;

    // Endpoint to create a new cron job
    @PostMapping
    public ResponseEntity<CronJob> createCronJob(@RequestBody CronJobRequest cronJobRequest) {
        CronJob newCronJob = cronJobService.createCronJob(String.valueOf(cronJobRequest.getClass()));
        return new ResponseEntity<>(newCronJob, HttpStatus.CREATED);
    }

    // Endpoint to update an existing cron job
    @PutMapping("/{cronJobId}")
    public ResponseEntity<CronJob> updateCronJob(@PathVariable Long cronJobId, @RequestBody CronJobRequest cronJobRequest) {
        CronJob updatedCronJob = cronJobService.updateCronJob(cronJobId, String.valueOf(cronJobRequest.getClass()));
        if (updatedCronJob != null) {
            return new ResponseEntity<>(updatedCronJob, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a cron job
    @DeleteMapping("/{cronJobId}")
    public ResponseEntity<Void> deleteCronJob(@PathVariable Long cronJobId) {
        cronJobService.deleteCronJob(cronJobId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint to retrieve all cron jobs
    @GetMapping
    public ResponseEntity<List<CronJob>> getAllCronJobs() {
        List<CronJob> cronJobs = cronJobService.getAllCronJobs();
        return new ResponseEntity<>(cronJobs, HttpStatus.OK);
    }

    // Request payload class
    static class CronJobRequest {
        private String expression;

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }
    }
}
