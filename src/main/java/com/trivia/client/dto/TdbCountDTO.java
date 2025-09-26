package com.trivia.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TdbCountDTO {
    private Long total_num_of_questions;
    private Long total_num_of_pending_questions;
    private Long total_num_of_verified_questions;
    private Long total_num_of_rejected_questions;
}
