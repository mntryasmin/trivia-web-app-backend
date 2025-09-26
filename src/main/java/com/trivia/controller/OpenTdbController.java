package com.trivia.controller;

import com.trivia.client.OpenTdbClient;
import com.trivia.client.dto.TdbCategoriesDTO;
import com.trivia.client.dto.TdbQuestionsCountDTO;
import com.trivia.client.dto.TdbResetTokenDTO;
import com.trivia.client.dto.TdbTokenDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opentdb")
public class OpenTdbController {

    @Autowired
    private OpenTdbClient openTdbClient;

    @GetMapping("/token")
    public ResponseEntity<TdbTokenDTO> getToken() {
        return ResponseEntity.ok(openTdbClient.getToken());
    }

    @GetMapping("/token/reset")
    public ResponseEntity<TdbResetTokenDTO> resetToken(@RequestParam("token") String token) {
        return ResponseEntity.ok(openTdbClient.getResetToken(token));
    }

    @GetMapping("/trivia")
    public ResponseEntity<?> getTrivia(@RequestParam(name = "amount", defaultValue = "10") Long amount,
            @RequestParam(name = "token", required = false) String token) {
        return ResponseEntity.ok(openTdbClient.getTrivia(amount, token));
    }

    @GetMapping("/categories")
    public ResponseEntity<TdbCategoriesDTO> getAllCategories() {
        return ResponseEntity.ok(openTdbClient.getAllCategories());
    }

    @GetMapping("/count")
    public ResponseEntity<TdbQuestionsCountDTO> getQuestionsCount() {
        return ResponseEntity.ok(openTdbClient.getQuestionsCount());
    }
}
