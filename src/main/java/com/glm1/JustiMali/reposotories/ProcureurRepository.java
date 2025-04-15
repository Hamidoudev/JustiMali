package com.glm1.JustiMali.reposotories;

import com.glm1.JustiMali.entities.Procureur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcureurRepository extends JpaRepository<Procureur, Long> {
}
