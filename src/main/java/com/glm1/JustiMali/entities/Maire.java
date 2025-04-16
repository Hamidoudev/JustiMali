package com.glm1.JustiMali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "maires")
@Getter
@Setter
@NoArgsConstructor
public class Maire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @ManyToOne(optional = true)
    @JoinColumn(name = "commune_id", nullable = true)
    private Commune commune;



    @OneToMany(mappedBy = "maire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Demande> demandes = new ArrayList<>();

    public String getEmail() {
        return "";
    }
}
