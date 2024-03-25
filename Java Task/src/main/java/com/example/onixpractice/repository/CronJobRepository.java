package com.example.onixpractice.repository;


import com.example.onixpractice.model.CronJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CronJobRepository extends JpaRepository<CronJob, Long> {
}
