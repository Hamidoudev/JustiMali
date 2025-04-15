package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.entities.Policier;
import com.glm1.JustiMali.entities.Procureur;
import com.glm1.JustiMali.entities.Pv;
import com.glm1.JustiMali.reposotories.CitoyenRepository;
import com.glm1.JustiMali.reposotories.PVRepository;
import com.glm1.JustiMali.reposotories.PolicierRepository;
import com.glm1.JustiMali.reposotories.ProcureurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PvService {
    private final PVRepository pvRepository;
    private final CitoyenRepository citoyenRepository;
    private final ProcureurRepository procureurRepository;
    private final PolicierRepository policierRepository;

    public Pv createPV(Pv pv, Long citoyenId, Long procureurId, Long policierId) {
        Citoyen citoyen = citoyenRepository.findById(citoyenId)
                .orElseThrow(() -> new RuntimeException("Citoyen non trouvé"));
        Procureur procureur = procureurRepository.findById(procureurId)
                .orElseThrow(() -> new RuntimeException("Procureur non trouvé"));
        Policier policier = policierRepository.findById(policierId)
                .orElseThrow(() -> new RuntimeException("Policier non trouvé"));

        pv.setCitoyen(citoyen);
        pv.setProcureur(procureur);
        pv.setPolicier(policier);
        return pvRepository.save(pv);
    }
}
