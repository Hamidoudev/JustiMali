package com.glm1.JustiMali.services.impl;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.reposotories.CitoyenRepository;
import com.glm1.JustiMali.services.CitoyenService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitoyenServiceImpl implements CitoyenService {
    private final CitoyenRepository citoyenRepository;

    @Override
    @Transactional
    public Citoyen createCitoyen(Citoyen citoyen) {
        return citoyenRepository.save(citoyen);
    }

    @Override
    public List<Citoyen> getAllCitoyens() {
        return citoyenRepository.findAll();
    }

    @Override
    public Optional<Citoyen> getCitoyen(Long id) {
        return citoyenRepository.findById(id);
    }

    @Transactional
    @Override
    public Citoyen updateCitoyen(Long id, Citoyen citoyenDetails) {
        Citoyen citoyen = citoyenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Citoyen not found with id: " + id));

        // Update basic fields
        citoyen.setNom(citoyenDetails.getNom());
        citoyen.setPrenom(citoyenDetails.getPrenom());
        citoyen.setEmail(citoyenDetails.getEmail());
        citoyen.setAdresse(citoyenDetails.getAdresse());

        // Update other fields as needed
//        if (citoyenDetails.getCommune() != null) {
//            citoyen.setCommune(citoyenDetails.getCommune());
//        }

        return citoyenRepository.save(citoyen);
    }

    @Transactional
    @Override
    public void deleteCitoyen(Long id) {
        if (!citoyenRepository.existsById(id)) {
            throw new EntityNotFoundException("Citoyen not found with id: " + id);
        }
        citoyenRepository.deleteById(id);
    }

    @Override
    public List<Citoyen> getCitoyensByCommune(Long communeId) {
        return citoyenRepository.findByCommuneId(communeId);
    }

    @Override
    public List<Citoyen> searchCitoyens(String nom, String prenom) {
        if (StringUtils.hasText(nom) && StringUtils.hasText(prenom)) {
            return citoyenRepository.findByNomContainingIgnoreCaseAndPrenomContainingIgnoreCase(nom, prenom);
        } else if (StringUtils.hasText(nom)) {
            return citoyenRepository.findByNomContainingIgnoreCase(nom);
        } else if (StringUtils.hasText(prenom)) {
            return citoyenRepository.findByPrenomContainingIgnoreCase(prenom);
        } else {
            return citoyenRepository.findAll();
        }
    }
    @Override
    public List<Citoyen> searchCitoyens(String nom, String prenom, String email, String telephone) {
        return citoyenRepository
                .findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrEmailContainingIgnoreCaseOrTelephoneContainingIgnoreCase(
                        nom != null ? nom : "",
                        prenom != null ? prenom : "",
                        email != null ? email : "",
                        telephone != null ? telephone : ""
                );
}
}

