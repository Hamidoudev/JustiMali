package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.reposotories.CitoyenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitoyenService {
    private final CitoyenRepository citoyenRepository;

    public Citoyen createCitoyen(Citoyen citoyen) {
        return citoyenRepository.save(citoyen);
    }

    public Optional<Citoyen> getCitoyen(Long id) {
        return citoyenRepository.findById(id);
    }

    public List<Citoyen> getAllCitoyens() {
        return citoyenRepository.findAll();
    }
}
