package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Demande;
import com.glm1.JustiMali.services.DemandeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
@RequiredArgsConstructor
public class DemandeController {
    private final DemandeService demandeService;

    @PostMapping
    public ResponseEntity<Demande> createDemande(
            @RequestBody Demande demande,
            @RequestParam Long citoyenId,
            @RequestParam Long maireId) {
        return ResponseEntity.ok(demandeService.createDemande(demande, citoyenId, maireId));
    }

    @GetMapping("/citoyen/{citoyenId}")
    public ResponseEntity<List<Demande>> getDemandesByCitoyen(@PathVariable Long citoyenId) {
        return ResponseEntity.ok(demandeService.getDemandesByCitoyen(citoyenId));
    }
}
