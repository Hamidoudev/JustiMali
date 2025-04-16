package com.glm1.JustiMali.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "demandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private String type;
    private String status;

    private LocalDateTime dateCreation;
    private LocalDateTime dateMiseAJour;

    @ManyToOne
    @JoinColumn(name = "citoyen_id")
    private Citoyen citoyen;

    @ManyToOne
    @JoinColumn(name = "maire_id")
    private Maire maire;
}

