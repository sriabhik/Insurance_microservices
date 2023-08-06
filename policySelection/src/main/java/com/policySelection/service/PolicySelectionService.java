package com.policySelection.service;

import com.policySelection.entities.PolicySelection;

public interface PolicySelectionService {
    PolicySelection createPolicySelection(PolicySelection policySelection);

    PolicySelection getPolicyById(String policySelectionId);
}
