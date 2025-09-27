package com.trivia.controller;

import com.trivia.client.dto.TdbCategoriesDTO;
import com.trivia.client.dto.TdbQuestionsCountDTO;
import com.trivia.service.OpenTdbService;

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
    private OpenTdbService openTdbService;

    @GetMapping("/token")
    public ResponseEntity<String> getToken() {
        return ResponseEntity.ok(openTdbService.getToken());
    }

    @GetMapping("/token/reset")
    public ResponseEntity<String> resetToken(@RequestParam("token") String token) {
        return ResponseEntity.ok(openTdbService.resetToken(token));
    }

    @GetMapping("/trivia")
    public ResponseEntity<?> getTrivia(@RequestParam(name = "amount", defaultValue = "10") Long amount) {
        return ResponseEntity.ok(openTdbService.getTrivia(amount));
    }

    @GetMapping("/categories")
    public ResponseEntity<TdbCategoriesDTO> getAllCategories() {
        return ResponseEntity.ok(openTdbService.getAllCategories());
    }

    @GetMapping("/count")
    public ResponseEntity<TdbQuestionsCountDTO> getQuestionsCount() {
        return ResponseEntity.ok(openTdbService.getQuestionsCount());
    }
}
