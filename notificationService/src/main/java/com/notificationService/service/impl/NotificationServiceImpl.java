package com.notificationService.service.impl;

import com.netflix.discovery.converters.Auto;
import com.notificationService.entities.NotificationDetail;
import com.notificationService.entities.PolicyGeneration;
import com.notificationService.externals.PolicyGenerationService;
import com.notificationService.repositories.NotificationRepo;
import com.notificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private PolicyGenerationService policyGenerationService;
    @Autowired
    private NotificationRepo notificationRepo;
    @Override
    public NotificationDetail sendNotification(String policyGenerationId) {

        PolicyGeneration detail = this.policyGenerationService.getDocumentByDocumentId(policyGenerationId);
        NotificationDetail notificationDetail = new NotificationDetail();
        notificationDetail.setNotificationId(UUID.randomUUID().toString());
        notificationDetail.setCustomerEmail(detail.getCustomerEmail());
        notificationDetail.setCustomerName(detail.getCustomerName());
        notificationDetail.setAge(detail.getAge());
        notificationDetail.setGender(detail.getGender());
        notificationDetail.setAmount(detail.getAmount());
        notificationDetail.setPolicyGenerationId(detail.getPolicyGenerationId());
        notificationDetail.setEndDate(detail.getEndDate());
        notificationDetail.setStartDate(detail.getStartDate());
        notificationDetail.setPolicyType(detail.getPolicyType());
        notificationDetail.setTransactionId(detail.getTransactionId());
        notificationDetail.setPolicyName(detail.getPolicyName());
        this.notificationRepo.save(notificationDetail);
        return notificationDetail;
    }
}
