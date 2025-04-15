package com.glm1.JustiMali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "demandes")
@Getter
@Setter
@NoArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeDemande type; // CASIER, NATIONALITE, ACTE_NAISSANCE

    private LocalDate dateDemande;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut; // EN_COURS, APPROUVE, REJETE

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citoyen_id")
    private Citoyen citoyen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maire_id")
    private Maire maire;
}

