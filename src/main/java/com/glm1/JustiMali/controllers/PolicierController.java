package com.glm1.JustiMali.controllers;

import com.glm1.JustiMali.entities.Policier;

import com.glm1.JustiMali.services.PolicierService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policiers")
public class PolicierController {

    private final PolicierService policierService;

    public PolicierController(PolicierService policierService) {
        this.policierService = policierService;
    }

    @PostMapping
    public Policier createPolicer(@RequestBody Policier policier) {
        return PolicierService.createPolicier(policier);
    }
}
