package com.glm1.JustiMali.reposotories;

import com.glm1.JustiMali.entities.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PVRepository extends JpaRepository<Pv, Long> {
    List<Pv> findByCitoyenId(Long citoyenId);
    List<Pv> findByProcureurId(Long procureurId);
}
