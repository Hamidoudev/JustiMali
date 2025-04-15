package com.glm1.JustiMali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "procureurs")
@Getter
@Setter
@NoArgsConstructor
public class Procureur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @OneToMany(mappedBy = "procureur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pv> pvs = new ArrayList<>();

}
