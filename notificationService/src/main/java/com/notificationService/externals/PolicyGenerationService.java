package com.notificationService.externals;

import com.notificationService.entities.PolicyGeneration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "POLICY-GENERATION-SERVICE")
public interface PolicyGenerationService {
    @GetMapping("/getDocumentById/{policyGenerationId}")
    PolicyGeneration getDocumentByDocumentId(@PathVariable String policyGenerationId);
}
