package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Maire;
import com.glm1.JustiMali.reposotories.MaireRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MaireService {
    Maire createMaire(Maire maire);
    List<Maire> getAllMaires();
    Optional<Maire> getMaireById(Long id);
    Maire updateMaire(Long id, Maire maire);
    void deleteMaire(Long id);
    Optional<Maire> getMaireByCommune(Long communeId);
}
