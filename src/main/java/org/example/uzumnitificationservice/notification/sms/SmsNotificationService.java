package org.example.uzumnitificationservice.notification.sms;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.example.uzumnitificationservice.eskiz.EskizFeign;
import org.example.uzumnitificationservice.eskiz.dto.EskizAuthResponseDto;
import org.example.uzumnitificationservice.eskiz.dto.EskizSendSmsDto;
import org.example.uzumnitificationservice.notification.AbstractNotificationService;
import org.example.uzumnitificationservice.notification.dto.NotificationType;
import org.example.uzumnitificationservice.notification.dto.NotificationRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsNotificationService extends AbstractNotificationService {
    @Value("${uzum-notification-service.eskiz.access-token}")
    private String accessToken;
    private final EskizFeign eskizFeign;

    @Override
    public boolean supports(NotificationType notificationType) {
        return notificationType == NotificationType.SMS;
    }

    @Override
    public void sendNotification(NotificationRequestDto notificationRequestDto) {

        EskizSendSmsDto eskizSendSmsDto = new EskizSendSmsDto(notificationRequestDto.getPhoneNumber(), notificationRequestDto.getMessage());
        try {
            eskizFeign.sendSms(eskizSendSmsDto, accessToken);

        } catch (FeignException.Unauthorized e) {

            EskizAuthResponseDto eskizAuthResponseDto = eskizFeign.refreshToken(accessToken);
            accessToken = "Bearer " + eskizAuthResponseDto.getData().get("token");
            eskizFeign.sendSms(eskizSendSmsDto, accessToken);


        }
    }
}
