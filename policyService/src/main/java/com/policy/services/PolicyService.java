package com.policy.services;


import com.policy.entities.Policy;

import java.util.List;

public interface PolicyService {
    List<Policy> getAllPolicy();
    Policy getById(String pId);
    Policy savePolicy(Policy policy);
}
