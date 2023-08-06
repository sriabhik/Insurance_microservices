package com.policySelection.controllers;

import com.policySelection.entities.PolicySelection;
import com.policySelection.service.PolicySelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class policySelectionController {
    @Autowired
    private PolicySelectionService policySelectionService;

    @PostMapping("/policie/select")
    public ResponseEntity<PolicySelection> createPolicySelection(@RequestBody PolicySelection policySelection){
        PolicySelection ps = this.policySelectionService.createPolicySelection(policySelection);
        return new ResponseEntity<>(ps, HttpStatus.CREATED);
    }

    @GetMapping("/getPolicySelectionById/{policySelectionId}")
    public ResponseEntity<PolicySelection> getPolicySelectionById(@PathVariable String policySelectionId){
        PolicySelection policyDetail = this.policySelectionService.getPolicyById(policySelectionId);
        return new ResponseEntity<>(policyDetail,HttpStatus.OK);
    }


}
