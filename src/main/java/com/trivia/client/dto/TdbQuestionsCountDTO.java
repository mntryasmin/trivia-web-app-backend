package com.trivia.client.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TdbQuestionsCountDTO {
    private TdbCountDTO overall;
    private Map<String, TdbCountDTO> categories;
}
