package com.glm1.JustiMali.reposotories;

import com.glm1.JustiMali.entities.Policier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicierRepository extends JpaRepository<Policier, Long> {
    Optional<Policier> findByMatricule(String matricule);
}
