package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Pv;
import com.glm1.JustiMali.services.PvService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pv")
@RequiredArgsConstructor
public class PvController {
    private final PvService pvService;

    @PostMapping
    @Operation(summary = "Create a new PV")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PV created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Pv> createPV(
            @RequestBody Pv pv,
            @RequestParam Long citoyenId,
            @RequestParam Long procureurId,
            @RequestParam Long policierId) {
        return ResponseEntity.ok(pvService.createPV(pv, citoyenId, procureurId, policierId));
    }

    @GetMapping
    @Operation(summary = "Get all PVs")
    public ResponseEntity<List<Pv>> getAllPVs() {
        return ResponseEntity.ok(pvService.getAllPVs());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get PV by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the PV"),
            @ApiResponse(responseCode = "404", description = "PV not found")
    })
    public ResponseEntity<Pv> getPVById(@PathVariable Long id) {
        return pvService.getPVById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing PV")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PV updated successfully"),
            @ApiResponse(responseCode = "404", description = "PV not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Pv> updatePV(
            @PathVariable Long id,
            @RequestBody Pv pv,
            @RequestParam(required = false) Long citoyenId,
            @RequestParam(required = false) Long procureurId,
            @RequestParam(required = false) Long policierId) {
        return ResponseEntity.ok(pvService.updatePV(id, pv, citoyenId, procureurId, policierId));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a PV")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "PV deleted successfully"),
            @ApiResponse(responseCode = "404", description = "PV not found")
    })
    public ResponseEntity<Void> deletePV(@PathVariable Long id) {
        pvService.deletePV(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/citoyen/{citoyenId}")
    @Operation(summary = "Get all PVs for a specific citizen")
    public ResponseEntity<List<Pv>> getPVsByCitoyenId(@PathVariable Long citoyenId) {
        return ResponseEntity.ok(pvService.getPVsByCitoyenId(citoyenId));
    }

    @GetMapping("/procureur/{procureurId}")
    @Operation(summary = "Get all PVs for a specific prosecutor")
    public ResponseEntity<List<Pv>> getPVsByProcureurId(@PathVariable Long procureurId) {
        return ResponseEntity.ok(pvService.getPVsByProcureurId(procureurId));
    }

    @GetMapping("/policier/{policierId}")
    @Operation(summary = "Get all PVs for a specific police officer")
    public ResponseEntity<List<Pv>> getPVsByPolicierId(@PathVariable Long policierId) {
        return ResponseEntity.ok(pvService.getPVsByPolicierId(policierId));
    }
}
