package com.trivia.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TdbResetTokenDTO {
    private Long response_code;
    private String token;
}
