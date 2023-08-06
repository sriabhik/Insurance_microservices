package com.policyGeneration.externals;

import com.policyGeneration.entities.PolicySelection;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "POLICY-SELECTION-SERVICE")
public interface PolicySelectionService {
    @GetMapping("/getPolicySelectionById/{policySelectionId}")
    PolicySelection getPolicyById(@PathVariable String policySelectionId);
}
