package com.glm1.JustiMali.services.impl;

import com.glm1.JustiMali.entities.Citoyen;
import com.glm1.JustiMali.entities.Policier;
import com.glm1.JustiMali.entities.Procureur;
import com.glm1.JustiMali.entities.Pv;
import com.glm1.JustiMali.reposotories.CitoyenRepository;
import com.glm1.JustiMali.reposotories.PolicierRepository;
import com.glm1.JustiMali.reposotories.ProcureurRepository;
import com.glm1.JustiMali.reposotories.PvRepository;
import com.glm1.JustiMali.services.PvService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PvServiceImpl implements PvService {
    private final PvRepository pvRepository;
    private final CitoyenRepository citoyenRepository;
    private final ProcureurRepository procureurRepository;
    private final PolicierRepository policierRepository;

    @Override
    @Transactional
    public Pv createPV(Pv pv, Long citoyenId, Long procureurId, Long policierId) {
        Citoyen citoyen = citoyenRepository.findById(citoyenId)
                .orElseThrow(() -> new EntityNotFoundException("Citoyen not found with id: " + citoyenId));

        Procureur procureur = procureurRepository.findById(procureurId)
                .orElseThrow(() -> new EntityNotFoundException("Procureur not found with id: " + procureurId));

        Policier policier = policierRepository.findById(policierId)
                .orElseThrow(() -> new EntityNotFoundException("Policier not found with id: " + policierId));

        pv.setCitoyen(citoyen);
        pv.setProcureur(procureur);
        pv.setPolicier(policier);

        return pvRepository.save(pv);
    }

    @Override
    public List<Pv> getAllPVs() {
        return pvRepository.findAll();
    }

    @Override
    public Optional<Pv> getPVById(Long id) {
        return pvRepository.findById(id);
    }

    @Override
    @Transactional
    public Pv updatePV(Long id, Pv pvDetails, Long citoyenId, Long procureurId, Long policierId) {
        Pv pv = pvRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PV not found with id: " + id));

        // Update basic fields
        pv.setNumero(pvDetails.getNumero());
        pv.setInfraction(pvDetails.getInfraction());
        pv.setDatePV(pvDetails.getDatePV());

        // Update relationships if IDs are provided
        if (citoyenId != null) {
            Citoyen citoyen = citoyenRepository.findById(citoyenId)
                    .orElseThrow(() -> new EntityNotFoundException("Citoyen not found with id: " + citoyenId));
            pv.setCitoyen(citoyen);
        }

        if (procureurId != null) {
            Procureur procureur = procureurRepository.findById(procureurId)
                    .orElseThrow(() -> new EntityNotFoundException("Procureur not found with id: " + procureurId));
            pv.setProcureur(procureur);
        }

        if (policierId != null) {
            Policier policier = policierRepository.findById(policierId)
                    .orElseThrow(() -> new EntityNotFoundException("Policier not found with id: " + policierId));
            pv.setPolicier(policier);
        }

        return pvRepository.save(pv);
    }

    @Override
    @Transactional
    public void deletePV(Long id) {
        if (!pvRepository.existsById(id)) {
            throw new EntityNotFoundException("PV not found with id: " + id);
        }
        pvRepository.deleteById(id);
    }

    @Override
    public List<Pv> getPVsByCitoyenId(Long citoyenId) {
        return pvRepository.findByCitoyenId(citoyenId);
    }

    @Override
    public List<Pv> getPVsByProcureurId(Long procureurId) {
        return pvRepository.findByProcureurId(procureurId);
    }

    @Override
    public List<Pv> getPVsByPolicierId(Long policierId) {
        return pvRepository.findByPolicierId(policierId);
    }
}
