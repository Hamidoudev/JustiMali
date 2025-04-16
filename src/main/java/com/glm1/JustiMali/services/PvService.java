package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.entities.Policier;
import com.glm1.JustiMali.entities.Procureur;
import com.glm1.JustiMali.entities.Pv;
import com.glm1.JustiMali.reposotories.CitoyenRepository;
import com.glm1.JustiMali.reposotories.PvRepository;
import com.glm1.JustiMali.reposotories.PolicierRepository;
import com.glm1.JustiMali.reposotories.ProcureurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PvService {
    Pv createPV(Pv pv, Long citoyenId, Long procureurId, Long policierId);
    List<Pv> getAllPVs();
    Optional<Pv> getPVById(Long id);
    Pv updatePV(Long id, Pv pv, Long citoyenId, Long procureurId, Long policierId);
    void deletePV(Long id);
    List<Pv> getPVsByCitoyenId(Long citoyenId);
    List<Pv> getPVsByProcureurId(Long procureurId);
    List<Pv> getPVsByPolicierId(Long policierId);
}
