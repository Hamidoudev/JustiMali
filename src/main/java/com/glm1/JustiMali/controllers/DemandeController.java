package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Demande;
import com.glm1.JustiMali.services.DemandeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Créer une nouvelle demande")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Demande créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Entrée invalide")
    })
    public ResponseEntity<Demande> createDemande(
            @RequestBody Demande demande,
            @RequestParam Long citoyenId,
            @RequestParam Long maireId) {
        return ResponseEntity.ok(demandeService.createDemande(demande, citoyenId, maireId));
    }

    @GetMapping
    @Operation(summary = "Obtenir toutes les demandes")
    public ResponseEntity<List<Demande>> getAllDemandes() {
        return ResponseEntity.ok(demandeService.getAllDemandes());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir une demande par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Demande trouvée"),
            @ApiResponse(responseCode = "404", description = "Demande non trouvée")
    })
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
        return demandeService.getDemandeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une demande existante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Demande mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Demande non trouvée"),
            @ApiResponse(responseCode = "400", description = "Entrée invalide")
    })
    public ResponseEntity<Demande> updateDemande(
            @PathVariable Long id,
            @RequestBody Demande demande,
            @RequestParam(required = false) Long citoyenId,
            @RequestParam(required = false) Long maireId) {
        return ResponseEntity.ok(demandeService.updateDemande(id, demande, citoyenId, maireId));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une demande")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Demande supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Demande non trouvée")
    })
    public ResponseEntity<Void> deleteDemande(@PathVariable Long id) {
        demandeService.deleteDemande(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/citoyen/{citoyenId}")
    @Operation(summary = "Obtenir les demandes par citoyen")
    public ResponseEntity<List<Demande>> getDemandesByCitoyen(@PathVariable Long citoyenId) {
        return ResponseEntity.ok(demandeService.getDemandesByCitoyen(citoyenId));
    }

    @GetMapping("/maire/{maireId}")
    @Operation(summary = "Obtenir les demandes par maire")
    public ResponseEntity<List<Demande>> getDemandesByMaire(@PathVariable Long maireId) {
        return ResponseEntity.ok(demandeService.getDemandesByMaire(maireId));
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Obtenir les demandes par statut")
    public ResponseEntity<List<Demande>> getDemandesByStatus(@PathVariable String status) {
        return ResponseEntity.ok(demandeService.getDemandesByStatus(status));
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Mettre à jour le statut d'une demande")
    public ResponseEntity<Demande> updateDemandeStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(demandeService.updateDemandeStatus(id, status));
    }
}
