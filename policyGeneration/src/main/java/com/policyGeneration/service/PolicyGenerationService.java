package com.policyGeneration.service;

import com.policyGeneration.entities.PolicyGeneration;

public interface PolicyGenerationService {
    String createPolicyDocument(String transactionId);
    PolicyGeneration getDocumentByDocumentId(String policyGenerationId);
}
