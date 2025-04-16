package com.glm1.JustiMali.services.impl;

import com.glm1.JustiMali.entities.Maire;
import com.glm1.JustiMali.reposotories.MaireRepository;
import com.glm1.JustiMali.services.MaireService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaireServiceImpl implements MaireService {
    private final MaireRepository maireRepository;

    @Transactional
    @Override
    public Maire createMaire(Maire maire) {
        return maireRepository.save(maire);
    }

    @Override
    public List<Maire> getAllMaires() {
        return maireRepository.findAll();
    }

    @Override
    public Optional<Maire> getMaireById(Long id) {
        return maireRepository.findById(id);
    }

    @Override
    @Transactional
    public Maire updateMaire(Long id, Maire maireDetails) {
        Maire maire = maireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maire not found with id: " + id));

        // Update basic fields
        maire.setNom(maireDetails.getNom());
        maire.setPrenom(maireDetails.getPrenom());
        maire.setCommune(maireDetails.getCommune());


        // Update other fields as needed
        if (maireDetails.getCommune() != null) {
            maire.setCommune(maireDetails.getCommune());
        }

        return maireRepository.save(maire);
    }

    @Override
    @Transactional
    public void deleteMaire(Long id) {
        if (!maireRepository.existsById(id)) {
            throw new EntityNotFoundException("Maire not found with id: " + id);
        }
        maireRepository.deleteById(id);
    }

    @Override
    public Optional<Maire> getMaireByCommune(Long communeId) {
        return maireRepository.findByCommuneId(communeId);
    }
}
