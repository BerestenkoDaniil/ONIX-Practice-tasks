package com.example.onixpractice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cron_jobs")
public class CronJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expression", nullable = false)
    private String expression;

    // Default constructor
    public CronJob() {
    }

    // Parameterized constructor
    public CronJob(String expression) {
        this.expression = expression;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
