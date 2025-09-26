package com.trivia.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TdbTriviaDTO {
    private Long response_code;
    private List<TdbQuestionDTO> results;
}
