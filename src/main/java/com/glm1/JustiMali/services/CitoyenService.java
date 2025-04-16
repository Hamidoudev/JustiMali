package com.glm1.JustiMali.services;

import com.glm1.JustiMali.entities.Citoyen;

import java.util.List;
import java.util.Optional;

public interface CitoyenService {
    Citoyen createCitoyen(Citoyen citoyen);
    List<Citoyen> getAllCitoyens();
    Optional<Citoyen> getCitoyen(Long id);
    Citoyen updateCitoyen(Long id, Citoyen citoyen);
    void deleteCitoyen(Long id);
    List<Citoyen> getCitoyensByCommune(Long communeId);
    List<Citoyen> searchCitoyens(String nom, String prenom);

    List<Citoyen> searchCitoyens(String nom, String prenom, String email, String telephone);

}
