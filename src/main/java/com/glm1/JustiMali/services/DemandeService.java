package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.entities.Demande;
import com.glm1.JustiMali.entities.Maire;
import com.glm1.JustiMali.reposotories.CitoyenRepository;
import com.glm1.JustiMali.reposotories.DemandeRepository;
import com.glm1.JustiMali.reposotories.MaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandeService {
    private final DemandeRepository demandeRepository;
    private final CitoyenRepository citoyenRepository;
    private final MaireRepository maireRepository;

    public Demande createDemande(Demande demande, Long citoyenId, Long maireId) {
        Citoyen citoyen = citoyenRepository.findById(citoyenId)
                .orElseThrow(() -> new RuntimeException("Citoyen non trouvé"));
        Maire maire = maireRepository.findById(maireId)
                .orElseThrow(() -> new RuntimeException("Maire non trouvé"));

        demande.setCitoyen(citoyen);
        demande.setMaire(maire);
        return demandeRepository.save(demande);
    }

    public List<Demande> getDemandesByCitoyen(Long citoyenId) {
        return demandeRepository.findByCitoyenId(citoyenId);
    }

}
