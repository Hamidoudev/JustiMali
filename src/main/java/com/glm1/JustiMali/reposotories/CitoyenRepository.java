package com.glm1.JustiMali.reposotories;

import com.glm1.JustiMali.entities.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CitoyenRepository extends JpaRepository<Citoyen, Long> {
    List<Citoyen> findByCommuneId(Long communeId);

    List<Citoyen> findByNomContainingIgnoreCase(String nom);
    List<Citoyen> findByPrenomContainingIgnoreCase(String prenom);
    List<Citoyen> findByNomContainingIgnoreCaseAndPrenomContainingIgnoreCase(String nom, String prenom);

    // Pour recherche avancée
    List<Citoyen> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrEmailContainingIgnoreCaseOrTelephoneContainingIgnoreCase(
            String nom, String prenom, String email, String telephone);

}

