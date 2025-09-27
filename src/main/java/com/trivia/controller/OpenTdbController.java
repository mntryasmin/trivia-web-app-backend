package com.trivia.controller;

import com.trivia.client.dto.TdbCategoriesDTO;
import com.trivia.client.dto.TdbQuestionsCountDTO;
import com.trivia.service.OpenTdbService;
import com.trivia.service.dto.TdbParamsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opentdb")
public class OpenTdbController {

    @Autowired
    private OpenTdbService openTdbService;

    @GetMapping("/token")
    public ResponseEntity<String> getToken() throws Exception {
        return ResponseEntity.ok(openTdbService.getToken());
    }

    @GetMapping("/token/reset")
    public ResponseEntity<String> resetToken(@RequestParam("token") String token) throws Exception {
        return ResponseEntity.ok(openTdbService.resetToken(token));
    }

    @PostMapping("/trivia")
    public ResponseEntity<?> getTrivia(@RequestBody TdbParamsDTO params) throws Exception {
        return ResponseEntity.ok(openTdbService.getTrivia(params));
    }

    @GetMapping("/categories")
    public ResponseEntity<TdbCategoriesDTO> getAllCategories() throws Exception {
        return ResponseEntity.ok(openTdbService.getAllCategories());
    }

    @GetMapping("/count")
    public ResponseEntity<TdbQuestionsCountDTO> getQuestionsCount() throws Exception {
        return ResponseEntity.ok(openTdbService.getQuestionsCount());
    }
}
