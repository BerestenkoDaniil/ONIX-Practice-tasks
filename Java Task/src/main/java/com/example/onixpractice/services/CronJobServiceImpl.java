package com.example.onixpractice.services;


import com.example.onixpractice.model.CronJob;
import com.example.onixpractice.repository.CronJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CronJobServiceImpl implements CronJobService {

    @Autowired
    private CronJobRepository cronJobRepository;

    @Override
    public CronJob createCronJob(String expression) {
        CronJob cronJob = new CronJob(expression);
        return cronJobRepository.save(cronJob);
    }

    @Override
    public CronJob updateCronJob(Long id, String expression) {
        Optional<CronJob> optionalCronJob = cronJobRepository.findById(id);
        optionalCronJob.ifPresent(cronJob -> {
            cronJob.setExpression(expression);
            cronJobRepository.save(cronJob);
        });
        return optionalCronJob;
    }

    @Override
    public void deleteCronJob(Long id) {
        cronJobRepository.deleteById(id);
    }

    @Override
    public List<CronJob> getAllCronJobs() {
        return cronJobRepository.findAll();
    }

    @Override
    public Optional<CronJob> getCronJobById(Long id) {
        return cronJobRepository.findById(id);
    }
}