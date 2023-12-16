package org.example.uzumnitificationservice.notification;

import org.example.uzumnitificationservice.notification.dto.NotificationRequestDto;
import org.example.uzumnitificationservice.notification.dto.NotificationType;

public abstract class AbstractNotificationService {

    public abstract boolean supports(NotificationType notificationType);

    public abstract void sendNotification(NotificationRequestDto notificationRequestDto);
}
