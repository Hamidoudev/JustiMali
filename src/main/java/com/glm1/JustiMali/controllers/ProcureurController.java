package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Procureur;
import com.glm1.JustiMali.services.ProcureurService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procureurs")
@RequiredArgsConstructor
public class ProcureurController {

    private final ProcureurService procureurService;

    // Créer un procureur
    @PostMapping
    public ResponseEntity<Procureur> createProcureur(@RequestBody Procureur procureur) {
        Procureur savedProcureur = procureurService.createProcureur(procureur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProcureur);
    }

    // Lister tous les procureurs
    @GetMapping
    public ResponseEntity<List<Procureur>> getAllProcureurs() {
        return ResponseEntity.ok(procureurService.findAll());
    }

    // Récupérer par ID
    @GetMapping("/{id}")
    public ResponseEntity<Procureur> getProcureurById(@PathVariable Long id) {
        return procureurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Mettre à jour
    @PutMapping("/{id}")
    public ResponseEntity<Procureur> updateProcureur(
            @PathVariable Long id,
            @RequestBody Procureur procureurDetails
    ) {
        return ResponseEntity.ok(procureurService.updateProcureur(id, procureurDetails));
    }

    // Supprimer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcureur(@PathVariable Long id) {
        procureurService.deleteProcureur(id);
        return ResponseEntity.noContent().build();
    }
}
