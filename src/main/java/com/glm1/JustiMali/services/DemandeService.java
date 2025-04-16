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
import java.util.Optional;


public interface DemandeService {
    Demande createDemande(Demande demande, Long citoyenId, Long maireId);
    List<Demande> getAllDemandes();
    Optional<Demande> getDemandeById(Long id);
    Demande updateDemande(Long id, Demande demande, Long citoyenId, Long maireId);
    void deleteDemande(Long id);
    List<Demande> getDemandesByCitoyen(Long citoyenId);
    List<Demande> getDemandesByMaire(Long maireId);
    List<Demande> getDemandesByStatus(String status);
    Demande updateDemandeStatus(Long id, String status);

}
