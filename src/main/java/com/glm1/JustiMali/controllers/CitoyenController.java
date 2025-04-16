package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.services.CitoyenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citoyens")
@RequiredArgsConstructor
public class CitoyenController {
    private final CitoyenService citoyenService;

    @PostMapping
    @Operation(summary = "Créer un nouveau citoyen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Citoyen créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Entrée invalide")
    })
    public ResponseEntity<Citoyen> createCitoyen(
            @RequestBody Citoyen citoyen,
            @RequestParam(required = false) Long communeId) {
        return ResponseEntity.ok(citoyenService.createCitoyen(citoyen));
    }

    @GetMapping
    @Operation(summary = "Obtenir tous les citoyens")
    public ResponseEntity<List<Citoyen>> getAllCitoyens() {
        return ResponseEntity.ok(citoyenService.getAllCitoyens());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un citoyen par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Citoyen trouvé"),
            @ApiResponse(responseCode = "404", description = "Citoyen non trouvé")
    })
    public ResponseEntity<Citoyen> getCitoyen(@PathVariable Long id) {
        return citoyenService.getCitoyen(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un citoyen existant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Citoyen mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Citoyen non trouvé"),
            @ApiResponse(responseCode = "400", description = "Entrée invalide")
    })
    public ResponseEntity<Citoyen> updateCitoyen(
            @PathVariable Long id,
            @RequestBody Citoyen citoyen,
            @RequestParam(required = false) Long communeId) {
        return ResponseEntity.ok(citoyenService.updateCitoyen(id, citoyen));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un citoyen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Citoyen supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Citoyen non trouvé")
    })
    public ResponseEntity<Void> deleteCitoyen(@PathVariable Long id) {
        citoyenService.deleteCitoyen(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/commune/{communeId}")
    @Operation(summary = "Obtenir les citoyens par commune")
    public ResponseEntity<List<Citoyen>> getCitoyensByCommune(@PathVariable Long communeId) {
        return ResponseEntity.ok(citoyenService.getCitoyensByCommune(communeId));
    }

    @GetMapping("/search")
    @Operation(summary = "Rechercher des citoyens par nom ou prénom")
    public ResponseEntity<List<Citoyen>> searchCitoyens(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String telephone) {
        return ResponseEntity.ok((List<Citoyen>) citoyenService.searchCitoyens(nom, prenom, email, telephone));
    }
}
