package org.example.uzumnitificationservice.eskiz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EskizSendSmsDto {

    @JsonProperty("mobile_phone")
    private String phoneNumber;
    private String message;
    private final String from = "4546";

}
