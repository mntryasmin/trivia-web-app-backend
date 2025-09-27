package com.trivia.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.trivia.client.dto.TdbCategoriesDTO;
import com.trivia.client.dto.TdbQuestionsCountDTO;
import com.trivia.client.dto.TdbResetTokenDTO;
import com.trivia.client.dto.TdbTokenDTO;
import com.trivia.client.dto.TdbTriviaDTO;
import com.trivia.service.dto.TdbParamsDTO;

@Component
public class OpenTdbClient {

    private static final String BASE_URL = "https://opentdb.com";

    private final RestTemplate restTemplate;

    public OpenTdbClient() {
        this.restTemplate = new RestTemplate();
    }

    public TdbTokenDTO getToken() {
        String url = BASE_URL + "/api_token.php?command=request";
        return restTemplate.getForObject(url, TdbTokenDTO.class);
    }

    public TdbResetTokenDTO getResetToken(String token) {
        String url = BASE_URL + "/api_token.php?command=request&token=" + token;
        return restTemplate.getForObject(url, TdbResetTokenDTO.class);
    }

    public TdbTriviaDTO getTrivia(TdbParamsDTO params) {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL + "/api.php?");
        boolean first = true;
        if (params.getAmount() != null) {
            urlBuilder.append(first ? "" : "&").append("amount=").append(params.getAmount());
            first = false;
        }
        if (params.getCategory() != null) {
            urlBuilder.append(first ? "" : "&").append("category=").append(params.getCategory());
            first = false;
        }
        if (params.getDifficulty() != null) {
            urlBuilder.append(first ? "" : "&").append("difficulty=").append(params.getDifficulty());
            first = false;
        }
        if (params.getType() != null) {
            urlBuilder.append(first ? "" : "&").append("type=").append(params.getType());
            first = false;
        }
        if (params.getToken() != null) {
            urlBuilder.append(first ? "" : "&").append("token=").append(params.getToken());
        }
        String url = urlBuilder.toString();
        return restTemplate.getForObject(url, TdbTriviaDTO.class);
    }

    public TdbCategoriesDTO getAllCategories() {
        String url = BASE_URL + "/api_category.php";
        return restTemplate.getForObject(url, TdbCategoriesDTO.class);
    }

    public TdbQuestionsCountDTO getQuestionsCount() {
        String url = BASE_URL + "/api_count_global.php";
        return restTemplate.getForObject(url, TdbQuestionsCountDTO.class);
    }
}
