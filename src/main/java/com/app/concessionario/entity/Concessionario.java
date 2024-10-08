package com.app.concessionario.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "concessionari")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Concessionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "indirizzo", length = 200)
    private String indirizzo;

    @Column(name = "p_iva", length = 11, nullable = false, unique = true)
    private String p_iva;

//    oneToMany con Clienti
    @OneToMany(mappedBy = "concessionario")
    @JsonBackReference
    private List<Cliente> clienti;

    //    oneToMany con Auto
    @OneToMany(mappedBy = "concessionario")
    @JsonBackReference
    private List<Auto> autos;
}
