package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Pv;
import com.glm1.JustiMali.services.PvService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{\n" +
        "  \"id\": 0,\n" +
        "  \"numero\": \"string\",\n" +
        "  \"infraction\": \"string\",\n" +
        "  \"datePV\": \"2025-04-15\",\n" +
        "  \"procureur\": {\n" +
        "    \"id\": 0,\n" +
        "    \"nom\": \"string\",\n" +
        "    \"prenom\": \"string\",\n" +
        "    \"email\": \"string\",\n" +
        "    \"telephone\": \"string\",\n" +
        "    \"pvs\": [\n" +
        "      \"string\"\n" +
        "    ]\n" +
        "  },")
@RequiredArgsConstructor
public class PvController {
    private final PvService pvService;

    @PostMapping
    public ResponseEntity<Pv> createPV(
            @RequestBody Pv pv,
            @RequestParam Long citoyenId,
            @RequestParam Long procureurId,
            @RequestParam Long policierId) {
        return ResponseEntity.ok(pvService.createPV(pv, citoyenId, procureurId, policierId));
    }
}
