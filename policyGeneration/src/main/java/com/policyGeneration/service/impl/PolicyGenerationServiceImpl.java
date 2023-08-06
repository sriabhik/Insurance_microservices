package com.policyGeneration.service.impl;

import com.policyGeneration.entities.Policy;
import com.policyGeneration.entities.PolicyGeneration;
import com.policyGeneration.entities.PolicySelection;
import com.policyGeneration.entities.Transaction;
import com.policyGeneration.externals.PolicySelectionService;
import com.policyGeneration.externals.PolicyService;
import com.policyGeneration.externals.TransactionService;
import com.policyGeneration.repositories.PolicyGenerationRepo;
import com.policyGeneration.service.PolicyGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Service
public class PolicyGenerationServiceImpl implements PolicyGenerationService {
    String pattern = "dd/MM/yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    @Autowired
    private PolicyGenerationRepo policyGenerationRepo;
    @Autowired
    private PolicySelectionService policySelectionService;
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PolicyService policyService;
    @Override
    public String createPolicyDocument(String transactionId) {

        Transaction transactionDetails = this.transactionService.getById(transactionId);
        System.out.println(transactionDetails.toString());
        System.out.println(transactionDetails.getTransactionId()+" -- "+ transactionDetails.getPolicySelectionId());
        //getPolicyDetails

        String policySelId = transactionDetails.getPolicySelectionId();
        System.out.println("Inside" + policySelId);
        PolicySelection pS = this.policySelectionService.getPolicyById(policySelId);

        Policy policyDetail = this.policyService.getById(pS.getPId());
        System.out.println(policyDetail.getName());
        PolicyGeneration pG = new PolicyGeneration();
        pG.setPolicyType(policyDetail.getType());
        pG.setPolicyName(policyDetail.getName());
        pG.setTransactionId(transactionDetails.getTransactionId());
        pG.setAmount(policyDetail.getAmount());
        String date = simpleDateFormat.format(new Date());
        pG.setStartDate(date);

        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, 360);
        Date d =cal.getTime();
        String date_end = simpleDateFormat.format(d);
        pG.setEndDate(date_end);
        pG.setPolicyGenerationId(UUID.randomUUID().toString());


        //getUser Deatils

        pG.setCustomerEmail(pS.getCustomerEmail());
        pG.setCustomerName(pS.getCustomerName());
        pG.setAge(pS.getAge());
        pG.setGender(pS.getGender());

        //save into database_ _ _ _
        this.policyGenerationRepo.save(pG);
        return pG.getPolicyGenerationId();
    }

    @Override
    public PolicyGeneration getDocumentByDocumentId(String policyGenerationId) {
        return this.policyGenerationRepo.findById(policyGenerationId).get();
    }
}
