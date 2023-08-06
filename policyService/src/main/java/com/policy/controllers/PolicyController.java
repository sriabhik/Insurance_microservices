package com.policy.controllers;

import com.policy.entities.Policy;
import com.policy.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PolicyController {
    @Autowired
    private PolicyService policyService;
    @GetMapping("/policies")
    public ResponseEntity<List<Policy>> getAllPolicy(){
         List<Policy> policyList = this.policyService.getAllPolicy();
         return  new ResponseEntity<>(policyList, HttpStatus.OK) ;
    }
    @GetMapping("/policies/{pId}")
    public ResponseEntity<Policy> getById(@PathVariable String pId){
        Policy p = this.policyService.getById(pId);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy){
        Policy savedPolicy = this.policyService.savePolicy(policy);
        return new ResponseEntity<>(savedPolicy, HttpStatus.CREATED);
    }
}
