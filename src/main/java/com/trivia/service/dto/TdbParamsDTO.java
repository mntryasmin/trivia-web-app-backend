package com.trivia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TdbParamsDTO {
    private Long amount;
    private Long category;
    private String difficulty;
    private String type;
    private String token;
}
