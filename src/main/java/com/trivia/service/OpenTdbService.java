package com.trivia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trivia.client.OpenTdbClient;
import com.trivia.client.dto.TdbCategoriesDTO;
import com.trivia.client.dto.TdbQuestionsCountDTO;
import com.trivia.client.dto.TdbResetTokenDTO;
import com.trivia.client.dto.TdbTokenDTO;
import com.trivia.client.dto.TdbTriviaDTO;
import com.trivia.exception.OpenTdbException;
import com.trivia.service.dto.TdbParamsDTO;

@Service
public class OpenTdbService {
    private static final Logger log = LoggerFactory.getLogger(OpenTdbService.class);

    @Autowired
    private OpenTdbClient openTdbClient;

    // Token
    @Cacheable({"opentdbToken"})
    public String getToken() throws Exception {
        try {
            log.info("Fetching token from OpenTDB");
            
            TdbTokenDTO tokenDTO = openTdbClient.getToken();
            log.debug("Token received: {}", tokenDTO.getToken());
            
            checkResponseCode(tokenDTO.getResponse_code());
            
            return tokenDTO.getToken();
        } catch (Exception e) {
            log.error("Error fetching token: {}", e.getMessage(), e);
            throw new Exception("Failed to get token: " + e.getMessage());
        }
    }

    @CacheEvict(value = "opentdbToken")
    public String resetToken(String token) throws Exception {
        try {
            log.info("Resetting token from OpenTDB");
            
            TdbResetTokenDTO resetToken = openTdbClient.getResetToken(token); 
            log.debug("New token received: {}", resetToken.getToken());
            
            checkResponseCode(resetToken.getResponse_code());       
            
            return resetToken.getToken();
        } catch (Exception e) {
            log.error("Error resetting token: {}", e.getMessage(), e);
            throw new Exception("Failed to reset token: " + e.getMessage());
        }
    }

    // Questions
    public TdbTriviaDTO getTrivia(TdbParamsDTO params) throws Exception {
        try {
            log.info("Fetching trivia questions");

            TdbTriviaDTO triviaDTO = openTdbClient.getTrivia(params);
            log.debug("Questions received: {}", triviaDTO);
            
            checkResponseCode(triviaDTO.getResponse_code());
            
            return triviaDTO;
        } catch (Exception e) {
            log.error("Error fetching trivia questions: {}", e.getMessage(), e);
            throw new Exception("Failed to get trivia questions: " + e.getMessage());
        }
    }

    public TdbCategoriesDTO getAllCategories() throws Exception {
        try {
            log.info("Fetching all categories from OpenTDB");
            return openTdbClient.getAllCategories();
        } catch (Exception e) {
            log.error("Error fetching categories: {}", e.getMessage(), e);
            throw new Exception("Failed to get all categories: " + e.getMessage());
        }
    }

    public TdbQuestionsCountDTO getQuestionsCount() throws Exception {
        try {
            log.info("Fetching questions count from OpenTDB");
            return openTdbClient.getQuestionsCount();
        } catch (Exception e) {
            log.error("Error fetching questions count: {}", e.getMessage(), e);
            throw new Exception("Failed to get questions count: " + e.getMessage());
        }
    }

    private void checkResponseCode(Long responseCode) {
        switch (responseCode.intValue()) {
            case 0: 
                return;
            case 1:
                throw new OpenTdbException("No Results: Not enough questions for your query.");
            case 2:
                throw new OpenTdbException("Invalid Parameter: Arguments passed are not valid.");
            case 3:
                throw new OpenTdbException("Token Not Found: Session Token does not exist.");
            case 4:
                throw new OpenTdbException("Token Empty: All possible questions returned. Reset token is necessary.");
            case 5:
                throw new OpenTdbException("Rate Limit: Too many requests. Please wait before retrying.");
            default:
                throw new OpenTdbException("Unknown error from OpenTDB.");
        }
    }
}
