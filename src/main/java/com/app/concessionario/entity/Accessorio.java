package com.app.concessionario.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "accessori")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Accessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    //    manyToMany con Auto
    @ManyToMany(mappedBy = "accessori")
    @JsonBackReference
    private List<Auto> auto;
}
