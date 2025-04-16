package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Commune;
import com.glm1.JustiMali.reposotories.CommuneRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/communes")
@RequiredArgsConstructor
public class CommuneController {
    private final CommuneRepository communeRepository;

    @PostMapping
    public ResponseEntity<Commune> createCommune(@RequestBody Commune commune) {
        return ResponseEntity.ok(communeRepository.save(commune));
    }

    @GetMapping
    public ResponseEntity<List<Commune>> getAllCommunes() {
        return ResponseEntity.ok(communeRepository.findAll());
    }

}
