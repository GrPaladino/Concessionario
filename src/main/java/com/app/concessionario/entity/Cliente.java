package com.app.concessionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clienti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 30)
    private String nome;

    @Column(name = "cognome", length = 30)
    private String cognome;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "telefono", length = 30)
    private String telefono;

//    manyToOne con concessionario
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "concessionario_id")
    private Concessionario concessionario;





}