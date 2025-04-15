package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Procureur;
import com.glm1.JustiMali.reposotories.ProcureurRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcureurService {
    private final ProcureurRepository procureurRepository;

    @Transactional
    public Procureur createProcureur(Procureur procureur) {
        return procureurRepository.save(procureur);
    }

    @Transactional
    public List<Procureur> findAll() {
        return procureurRepository.findAll();
    }

    @Transactional
    public Optional<Procureur> findById(Long id) {
        return procureurRepository.findById(id);
    }

    @Transactional
    public Procureur updateProcureur(Long id, Procureur procureurDetails) {
        Procureur procureur = procureurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procureur non trouvé avec l'id: " + id));

        procureur.setNom(procureurDetails.getNom());
        procureur.setPrenom(procureurDetails.getPrenom());
        procureur.setEmail(procureurDetails.getEmail());
        procureur.setTelephone(procureurDetails.getTelephone());

        return procureurRepository.save(procureur);
    }

    @Transactional
    public void deleteProcureur(Long id) {
        procureurRepository.deleteById(id);
    }
}
