package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Maire;
import com.glm1.JustiMali.services.MaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maires")
@RequiredArgsConstructor
public class MaireController {

    private final MaireService maireService;

    @PostMapping
    @Operation(summary = "Create a new Maire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Maire created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Maire> createMaire(@RequestBody @Valid Maire maire) {
        return ResponseEntity.ok(maireService.createMaire(maire));
    }

    @GetMapping
    @Operation(summary = "Get all Maires")
    public ResponseEntity<List<Maire>> getAllMaires() {
        return ResponseEntity.ok(maireService.getAllMaires());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Maire by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Maire"),
            @ApiResponse(responseCode = "404", description = "Maire not found")
    })
    public ResponseEntity<Maire> getMaireById(@PathVariable Long id) {
        return maireService.getMaireById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing Maire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Maire updated successfully"),
            @ApiResponse(responseCode = "404", description = "Maire not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Maire> updateMaire(@PathVariable Long id, @RequestBody Maire maire) {
        return ResponseEntity.ok(maireService.updateMaire(id, maire));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Maire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Maire deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Maire not found")
    })
    public ResponseEntity<Void> deleteMaire(@PathVariable Long id) {
        maireService.deleteMaire(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/commune/{communeId}")
    @Operation(summary = "Get Maire by Commune ID")
    public ResponseEntity<Maire> getMaireByCommune(@PathVariable Long communeId) {
        return maireService.getMaireByCommune(communeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
