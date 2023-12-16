package org.example.uzumnitificationservice.eskiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EskizAuthResponseDto {

    private Map<String, String> data;

}

