package com.example.onixpractice.controller;

import com.example.onixpractice.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<Void> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getUserId(),
                emailRequest.getSubject(),
                emailRequest.getBody());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    static class EmailRequest {
        private Long userId;
        private String subject;
        private String body;

        public Long getUserId() {
            return userId;
        }
        public String getSubject() {
            return subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
}
