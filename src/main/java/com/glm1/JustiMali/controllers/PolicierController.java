package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Policier;

import com.glm1.JustiMali.services.PolicierService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policiers")
@RequiredArgsConstructor
public class PolicierController {

    private final PolicierService policierService;

    // Créer un policier
    @PostMapping
    public ResponseEntity<Policier> createPolicier(@RequestBody Policier policier) {
        Policier savedPolicier = policierService.createPolicier(policier);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPolicier);
    }

    // Récupérer tous les policiers
    @GetMapping
    public ResponseEntity<List<Policier>> getAllPoliciers() {
        return ResponseEntity.ok(policierService.findAll());
    }

    // Récupérer par ID
    @GetMapping("/{id}")
    public ResponseEntity<Policier> getPolicierById(@PathVariable Long id) {
        return policierService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Rechercher par matricule
    @GetMapping("/matricule/{matricule}")
    public ResponseEntity<Policier> getByMatricule(@PathVariable String matricule) {
        return policierService.findByMatricule(matricule)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Mettre à jour
    @PutMapping("/{id}")
    public ResponseEntity<Policier> updatePolicier(
            @PathVariable Long id,
            @RequestBody Policier policierDetails
    ) {
        return ResponseEntity.ok(policierService.updatePolicier(id, policierDetails));
    }

    // Supprimer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicier(@PathVariable Long id) {
        policierService.deletePolicier(id);
        return ResponseEntity.noContent().build();
    }
}
