package com.glm1.JustiMali.reposotories;

import com.glm1.JustiMali.entities.Maire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaireRepository extends JpaRepository<Maire, Long> {
}
