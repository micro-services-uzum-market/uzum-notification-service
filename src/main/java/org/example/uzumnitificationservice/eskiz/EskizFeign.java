package org.example.uzumnitificationservice.eskiz;

import org.example.uzumnitificationservice.eskiz.dto.EskizAuthResponseDto;
import org.example.uzumnitificationservice.eskiz.dto.EskizSendSmsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "eskizFeign", url = "notify.eskiz.uz/api")
public interface EskizFeign {

    @RequestMapping(value = "/auth/refresh", method = RequestMethod.PATCH)
    EskizAuthResponseDto refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer);

    @PostMapping("/message/sms/send")
    String sendSms(@RequestBody EskizSendSmsDto sendSmsDto,
                   @RequestHeader(HttpHeaders.AUTHORIZATION) String bearer);
}

