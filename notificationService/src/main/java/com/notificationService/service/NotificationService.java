package com.notificationService.service;

import com.notificationService.entities.NotificationDetail;

public interface NotificationService {
    NotificationDetail sendNotification(String policyGenerationId);
}
