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
    private TdbDifficultyEnum difficulty;
    private TdbTypeEnum type;
    private String token;
    private TdbEncodeEnum encode;
}
