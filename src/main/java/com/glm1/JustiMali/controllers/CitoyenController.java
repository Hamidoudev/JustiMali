package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.services.CitoyenService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citoyens")
@RequiredArgsConstructor
public class CitoyenController {
    private final CitoyenService citoyenService;

    @PostMapping
    public ResponseEntity<Citoyen> createCitoyen(@RequestBody Citoyen citoyen) {
        return ResponseEntity.ok(citoyenService.createCitoyen(citoyen));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Citoyen> getCitoyen(@PathVariable Long id) {
        return citoyenService.getCitoyen(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
