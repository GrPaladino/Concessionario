package com.app.concessionario.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "motori")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Motore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "potenza", nullable = false)
    private Integer potenza;

    @Column(name = "cilindrata", nullable = false)
    private Double cilindrata;

    @Column(name = "carburante", length = 20, nullable = false)
    private String carburante;

    //    manyToMany con Auto

    @ManyToMany(mappedBy = "motori")
    @JsonBackReference
    private List<Auto> auto;


}
