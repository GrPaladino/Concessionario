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
    /**
     * Trovandoci nella Entity Motore, la joinColumns la settiamo sul campo a DB della colonna di riferimento di "questa entita'"
     * mentra la inverseJoinColumns la settiamo sul campo a DB che fa riferimento dell'altra Entity, Auto in questo caso
     */
    @ManyToMany
    @JoinTable(

            name = "automobile_motore",
            joinColumns = @JoinColumn(name = "motore_id"),
            inverseJoinColumns = @JoinColumn(name = "automobile_id")
    )
    @JsonBackReference
    private List<Auto> auto;


}
