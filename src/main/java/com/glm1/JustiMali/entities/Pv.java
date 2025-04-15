package com.glm1.JustiMali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pvs")
@Getter
@Setter
@NoArgsConstructor
public class Pv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String infraction;
    private LocalDate datePV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procureur_id")
    private Procureur procureur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policier_id")
    private Policier policier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citoyen_id")
    private Citoyen citoyen;
}
