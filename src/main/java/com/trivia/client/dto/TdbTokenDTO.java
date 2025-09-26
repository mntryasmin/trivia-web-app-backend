package com.trivia.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TdbTokenDTO {
    private Long response_code;
    private String response_message;
    private String token;
}
