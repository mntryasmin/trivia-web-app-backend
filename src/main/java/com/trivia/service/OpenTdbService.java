package com.trivia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.trivia.client.OpenTdbClient;
import com.trivia.client.dto.TdbCategoriesDTO;
import com.trivia.client.dto.TdbQuestionsCountDTO;
import com.trivia.client.dto.TdbResetTokenDTO;
import com.trivia.client.dto.TdbTriviaDTO;

@Service
public class OpenTdbService {

    @Autowired
    private OpenTdbClient openTdbClient;

    // Token
    @Cacheable({"opentdbToken"})
    public String getToken() {
        return openTdbClient.getToken().getToken();
    }

    @CacheEvict(value = "opentdbToken")
    public String resetToken(String token) {
        TdbResetTokenDTO resetToken = openTdbClient.getResetToken(token);
        return resetToken.getToken();
    }

    // Questions
    public TdbTriviaDTO getTrivia(Long amount) {
        String token = getToken();
        return openTdbClient.getTrivia(amount, token);
    }

    public TdbCategoriesDTO getAllCategories() {
        return openTdbClient.getAllCategories();
    }

    public TdbQuestionsCountDTO getQuestionsCount() {
        return openTdbClient.getQuestionsCount();
    }
}
