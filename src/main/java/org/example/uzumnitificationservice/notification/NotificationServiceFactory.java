package org.example.uzumnitificationservice.notification;

import lombok.RequiredArgsConstructor;
import org.example.uzumnitificationservice.notification.dto.NotificationType;
import org.springframework.stereotype.Component;


import java.util.List;

@RequiredArgsConstructor
@Component
public class NotificationServiceFactory {

    private final List<AbstractNotificationService> notificationServices;

    public AbstractNotificationService getService(NotificationType notificationType) {

        for (AbstractNotificationService notificationService : notificationServices) {
            if (notificationService.supports(notificationType)) {
                return notificationService;
            }

        }
        throw new IllegalArgumentException("%s notification type is not supported".formatted(notificationType));
    }

}
