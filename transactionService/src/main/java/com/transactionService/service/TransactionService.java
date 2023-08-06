package com.transactionService.service;

import com.transactionService.entities.Transaction;

public interface TransactionService {
    Transaction makePayment(String policySelectionId);
    Transaction getById(String transactionId);
}
