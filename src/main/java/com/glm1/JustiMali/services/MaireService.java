package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Maire;
import com.glm1.JustiMali.reposotories.MaireRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaireService {
    private final MaireRepository maireRepository;

    @Transactional
    public Maire createMaire(Maire maire) {
        return maireRepository.save(maire);
    }

    @Transactional
    public List<Maire> findAll() {
        return maireRepository.findAll();
    }

    @Transactional
    public Optional<Maire> findById(Long id) {
        return maireRepository.findById(id);
    }

    @Transactional
    public Maire updateMaire(Long id, Maire maireDetails) {
        Maire maire = maireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maire non trouvé avec l'id: " + id));

        maire.setNom(maireDetails.getNom());
        maire.setPrenom(maireDetails.getPrenom());
        maire.setCommune(maireDetails.getCommune());

        return maireRepository.save(maire);
    }

    @Transactional
    public void deleteMaire(Long id) {
        maireRepository.deleteById(id);
    }
}
