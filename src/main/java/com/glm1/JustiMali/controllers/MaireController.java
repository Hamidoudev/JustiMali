package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Maire;
import com.glm1.JustiMali.services.MaireService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maires")
public class MaireController {

    private final MaireService maireService;

    public MaireController(MaireService maireService) {
        this.maireService = maireService;
    }

    @PostMapping
    public Maire createMaire(@RequestBody Maire maire) {
        return maireService.createMaire(maire);
    }
}
