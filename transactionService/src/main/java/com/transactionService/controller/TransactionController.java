package com.transactionService.controller;

import com.netflix.discovery.converters.Auto;
import com.transactionService.entities.Transaction;
import com.transactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/payments/{policySelectionId}")
    public ResponseEntity<Transaction> makePayment(@PathVariable String policySelectionId){
        Transaction isSuccess = this.transactionService.makePayment(policySelectionId);
        return new ResponseEntity<>(isSuccess, HttpStatus.OK);
    }
    @GetMapping("/getById/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String transactionId){
        Transaction transactionDetail = this.transactionService.getById(transactionId);
        return new ResponseEntity<>(transactionDetail, HttpStatus.OK);
    }
}
