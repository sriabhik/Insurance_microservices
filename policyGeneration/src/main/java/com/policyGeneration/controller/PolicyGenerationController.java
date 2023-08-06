package com.policyGeneration.controller;

import com.policyGeneration.entities.PolicyGeneration;
import com.policyGeneration.service.PolicyGenerationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PolicyGenerationController {
    @Autowired
    private PolicyGenerationService policyGenerationService;

    @PostMapping("/policy/generate/{transactionId}")
    @CircuitBreaker(name = "ServiceDown",fallbackMethod = "ServiceDownFallbackMethod")
    public ResponseEntity<String> generatePolicyDocument(@PathVariable String transactionId){
        String documentId =this.policyGenerationService.createPolicyDocument(transactionId);
        return new ResponseEntity<>(documentId, HttpStatus.OK);
    }

    @GetMapping("/getDocumentById/{policyGenerationId}")
    public  ResponseEntity<PolicyGeneration> getDocumentById(@PathVariable String policyGenerationId){
        PolicyGeneration documentDetail = this.policyGenerationService.getDocumentByDocumentId(policyGenerationId);
        return new ResponseEntity<>(documentDetail,HttpStatus.OK);
    }
    public ResponseEntity<String> ServiceDownFallbackMethod(Exception ex) {

        return new ResponseEntity<>("Services are Down,Try Later", HttpStatus.OK);
    }
}
