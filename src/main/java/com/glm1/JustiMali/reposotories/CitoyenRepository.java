package com.glm1.JustiMali.reposotories;

import com.glm1.JustiMali.entities.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitoyenRepository extends JpaRepository<Citoyen, Long> {
    Optional<Citoyen> findByNumeroIdentification(String numeroIdentification);
}

