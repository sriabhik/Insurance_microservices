package com.policySelection.service.impl;

import com.policySelection.entities.PolicySelection;
import com.policySelection.repositories.PolicySelectionRepo;
import com.policySelection.service.PolicySelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PolicySelectionServiceImpl implements PolicySelectionService {
    @Autowired
    private PolicySelectionRepo policySelectionRepo;

    @Override
    public PolicySelection createPolicySelection(PolicySelection policySelection) {
        PolicySelection savedDetail = new PolicySelection();

        savedDetail.setPolicySelectionId(UUID.randomUUID().toString());
        System.out.println("pid: "+policySelection.getPId());
        savedDetail.setPId(policySelection.getPId());
        savedDetail.setCustomerEmail(policySelection.getCustomerEmail());
        savedDetail.setCustomerName(policySelection.getCustomerName());
        savedDetail.setAge(policySelection.getAge());
        savedDetail.setGender(policySelection.getGender());

        this.policySelectionRepo.save(savedDetail);
        return savedDetail;

    }

    @Override
    public PolicySelection getPolicyById(String policySelectionId) {
        return this.policySelectionRepo.findById(policySelectionId).get();
    }
}
