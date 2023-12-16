package org.example.uzumnitificationservice.notification.telegram;

import lombok.RequiredArgsConstructor;
import org.example.uzumnitificationservice.notification.AbstractNotificationService;
import org.example.uzumnitificationservice.notification.dto.NotificationType;
import org.example.uzumnitificationservice.notification.dto.NotificationRequestDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelegramNotificationService extends AbstractNotificationService {


    @Override
    public boolean supports(NotificationType notificationType) {
        return notificationType == NotificationType.TELEGRAM;
    }

    @Override
    public void sendNotification(NotificationRequestDto notificationRequestDto) {

        System.out.print("telegram");
    }
}
