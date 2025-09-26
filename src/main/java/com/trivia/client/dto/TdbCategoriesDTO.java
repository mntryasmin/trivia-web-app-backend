package com.trivia.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TdbCategoriesDTO {
    private List<TdbCategoryDTO> trivia_categories;
}
