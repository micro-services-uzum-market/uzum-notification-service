package org.example.uzumnitificationservice.notification;


import lombok.RequiredArgsConstructor;
import org.example.uzumnitificationservice.notification.dto.NotificationRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationServiceFactory service;


    @PostMapping
    public void sendNotification(@RequestBody NotificationRequestDto notificationRequestDto) {

        AbstractNotificationService sms = service.getService(notificationRequestDto.getNotificationType());
        sms.sendNotification(notificationRequestDto);

    }

}
