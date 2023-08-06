package com.policy.services.impl;


import com.policy.entities.Policy;
import com.policy.repositories.PolicyRepo;
import com.policy.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyRepo policyRepo;
    @Override
    public List<Policy> getAllPolicy() {
        return this.policyRepo.findAll();
    }
    @Override
    public Policy getById(String pId) {
        return this.policyRepo.findById(pId).get();
    }
    @Override
    public Policy savePolicy(Policy policy)
    {
        Policy p = new Policy();
        p.setPId(UUID.randomUUID().toString());
        p.setAmount(policy.getAmount());
        p.setType(policy.getType());
        p.setName(policy.getName());
        return policyRepo.save(p);
    }
}
