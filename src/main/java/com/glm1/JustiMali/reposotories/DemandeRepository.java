package com.glm1.JustiMali.reposotories;

import com.glm1.JustiMali.entities.Demande;
import com.glm1.JustiMali.entities.TypeDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByCitoyenId(Long citoyenId);
    List<Demande> findByType(TypeDemande type);
}
