package com.glm1.JustiMali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "policiers")
@Getter
@Setter
@NoArgsConstructor
public class Policier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricule;
    private String nom;
    private String prenom;
    private String grade;

    @OneToMany(mappedBy = "policier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pv> pvs = new ArrayList<>();
}
