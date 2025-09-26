package com.trivia.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.trivia.client.dto.TdbCategoriesDTO;
import com.trivia.client.dto.TdbQuestionsCountDTO;
import com.trivia.client.dto.TdbResetTokenDTO;
import com.trivia.client.dto.TdbTokenDTO;
import com.trivia.client.dto.TdbTriviaDTO;

@Component
public class OpenTdbClient {

    private static final String BASE_URL = "https://opentdb.com";

    private final RestTemplate restTemplate;

    public OpenTdbClient() {
        this.restTemplate = new RestTemplate();
    }

    public TdbTokenDTO getToken() {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .path("/api_token.php")
                .queryParam("command", "request")
                .toUriString();
        return restTemplate.getForObject(url, TdbTokenDTO.class);
    }

    public TdbResetTokenDTO getResetToken(String token) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .path("/api_token.php")
                .queryParam("command", "request")
                .queryParam("token", token)
                .toUriString();
        return restTemplate.getForObject(url, TdbResetTokenDTO.class);
    }

    public TdbTriviaDTO getTrivia(Long amount, String token) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .path("/api.php")
                .queryParam("amount", amount)
                .queryParam("token", token)
                .toUriString();
        return restTemplate.getForObject(url, TdbTriviaDTO.class);
    }

    public TdbCategoriesDTO getAllCategories() {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .path("/api_category.php")
                .toUriString();
        return restTemplate.getForObject(url, TdbCategoriesDTO.class);
    }

    public TdbQuestionsCountDTO getQuestionsCount() {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .path("/api_count_global.php")
                .toUriString();
        return restTemplate.getForObject(url, TdbQuestionsCountDTO.class);
    }
}
