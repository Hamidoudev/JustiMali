package com.glm1.JustiMali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "communes")
    @Getter
    @Setter
    @NoArgsConstructor
    public class Commune {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nom;

        @OneToMany(mappedBy = "commune")
        private List<Citoyen> citoyens = new ArrayList<>();

}
