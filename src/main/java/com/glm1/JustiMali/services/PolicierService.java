package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Policier;
import com.glm1.JustiMali.reposotories.PolicierRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicierService {
    private final PolicierRepository policierRepository;

    @Transactional
    public Policier createPolicier(Policier policier) {
        return policierRepository.save(policier);
    }

    @Transactional
    public List<Policier> findAll() {
        return policierRepository.findAll();
    }

    @Transactional
    public Optional<Policier> findById(Long id) {
        return policierRepository.findById(id);
    }

    @Transactional
    public Optional<Policier> findByMatricule(String matricule) {
        return policierRepository.findByMatricule(matricule);
    }

    @Transactional
    public Policier updatePolicier(Long id, Policier policierDetails) {
        Policier policier = policierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policier non trouvé avec l'id: " + id));

        policier.setMatricule(policierDetails.getMatricule());
        policier.setNom(policierDetails.getNom());
        policier.setPrenom(policierDetails.getPrenom());
        policier.setGrade(policierDetails.getGrade());

        return policierRepository.save(policier);
    }

    @Transactional
    public void deletePolicier(Long id) {
        policierRepository.deleteById(id);
    }
}
