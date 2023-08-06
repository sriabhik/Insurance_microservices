package com.notificationService.controller;

import com.notificationService.entities.NotificationDetail;
import com.notificationService.service.NotificationService;
import feign.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("*")

public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/notification/email/{policyGenerationId}")
    @CircuitBreaker(name = "policyGeneration",fallbackMethod = "policyGenerationMethod")
    public ResponseEntity<NotificationDetail> sendEmail(@PathVariable String policyGenerationId){
        NotificationDetail notificationDetail = this.notificationService.sendNotification(policyGenerationId);
        return new ResponseEntity<>(notificationDetail, HttpStatus.OK);
    }
    public ResponseEntity<NotificationDetail> policyGenerationMethod(String accountNumber, Exception ex) {

        NotificationDetail nf = new NotificationDetail();
        nf.setPolicyName("Policy Generation Service is Donw");
        nf.setPolicyType("Policy Generation Service is Down");
        nf.setTransactionId("Policy Generation is Down");
        return new ResponseEntity<>(nf, HttpStatus.OK);

    }
}
