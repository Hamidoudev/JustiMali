package com.glm1.JustiMali.services.impl;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.entities.Demande;
import com.glm1.JustiMali.entities.Maire;
import com.glm1.JustiMali.reposotories.CitoyenRepository;
import com.glm1.JustiMali.reposotories.DemandeRepository;
import com.glm1.JustiMali.reposotories.MaireRepository;
import com.glm1.JustiMali.services.DemandeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl implements DemandeService {
    private final DemandeRepository demandeRepository;
    private final CitoyenRepository citoyenRepository;
    private final MaireRepository maireRepository;

    @Override
    @Transactional
    public Demande createDemande(Demande demande, Long citoyenId, Long maireId) {
        Citoyen citoyen = citoyenRepository.findById(citoyenId)
                .orElseThrow(() -> new EntityNotFoundException("Citoyen non trouvé avec l'id: " + citoyenId));

        Maire maire = maireRepository.findById(maireId)
                .orElseThrow(() -> new EntityNotFoundException("Maire non trouvé avec l'id: " + maireId));

        demande.setCitoyen(citoyen);
        demande.setMaire(maire);

        // Définir des valeurs par défaut si nécessaire
        if (demande.getDateCreation() == null) {
            demande.setDateCreation(LocalDateTime.now());
        }

        if (demande.getStatus() == null || demande.getStatus().isEmpty()) {
            demande.setStatus("EN_ATTENTE");
        }

        return demandeRepository.save(demande);
    }

    @Override
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @Override
    public Optional<Demande> getDemandeById(Long id) {
        return demandeRepository.findById(id);
    }

    @Override
    @Transactional
    public Demande updateDemande(Long id, Demande demandeDetails, Long citoyenId, Long maireId) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demande non trouvée avec l'id: " + id));

        // Mettre à jour les champs de base
        demande.setTitre(demandeDetails.getTitre());
        demande.setDescription(demandeDetails.getDescription());
        demande.setType(demandeDetails.getType());

        // Ne pas écraser la date de création
        if (demandeDetails.getDateMiseAJour() == null) {
            demande.setDateMiseAJour(LocalDateTime.now());
        } else {
            demande.setDateMiseAJour(demandeDetails.getDateMiseAJour());
        }

        // Mettre à jour le statut si fourni
        if (demandeDetails.getStatus() != null && !demandeDetails.getStatus().isEmpty()) {
            demande.setStatus(demandeDetails.getStatus());
        }

        // Mettre à jour les relations si les IDs sont fournis
        if (citoyenId != null) {
            Citoyen citoyen = citoyenRepository.findById(citoyenId)
                    .orElseThrow(() -> new EntityNotFoundException("Citoyen non trouvé avec l'id: " + citoyenId));
            demande.setCitoyen(citoyen);
        }

        if (maireId != null) {
            Maire maire = maireRepository.findById(maireId)
                    .orElseThrow(() -> new EntityNotFoundException("Maire non trouvé avec l'id: " + maireId));
            demande.setMaire(maire);
        }

        return demandeRepository.save(demande);
    }

    @Override
    @Transactional
    public void deleteDemande(Long id) {
        if (!demandeRepository.existsById(id)) {
            throw new EntityNotFoundException("Demande non trouvée avec l'id: " + id);
        }
        demandeRepository.deleteById(id);
    }

    @Override
    public List<Demande> getDemandesByCitoyen(Long citoyenId) {
        return demandeRepository.findByCitoyenId(citoyenId);
    }

    @Override
    public List<Demande> getDemandesByMaire(Long maireId) {
        return demandeRepository.findByMaireId(maireId);
    }

    @Override
    public List<Demande> getDemandesByStatus(String status) {
        return demandeRepository.findByStatusIgnoreCase(status);
    }

    @Override
    @Transactional
    public Demande updateDemandeStatus(Long id, String status) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demande non trouvée avec l'id: " + id));

        demande.setStatus(status);
        demande.setDateMiseAJour(LocalDateTime.now());

        return demandeRepository.save(demande);
    }
}
