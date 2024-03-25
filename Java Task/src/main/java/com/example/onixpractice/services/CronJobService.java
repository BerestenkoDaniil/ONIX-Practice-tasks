package com.example.onixpractice.services;


import com.example.onixpractice.model.CronJob;

import java.util.List;
import java.util.Optional;



public interface CronJobService {
    CronJob createCronJob(String expression);
    CronJob updateCronJob(Long id, String expression);
    void deleteCronJob(Long id);
    List<CronJob> getAllCronJobs();
    Optional<CronJob> getCronJobById(Long id);
}

