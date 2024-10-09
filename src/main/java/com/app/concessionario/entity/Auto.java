package com.app.concessionario.entity;

import com.app.concessionario.utils.enumerate.Carrozzeria;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "automobili")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "modello", length = 50, nullable = false)
    private String modello;

    @Column(name = "colore", length = 20)
    private String colore;

    @Column(name = "stato", columnDefinition = "nuova")
    private String stato;

    @Column(name = "carrozzeria")
    @Enumerated(EnumType.STRING)
    private Carrozzeria carrozzeria;

    @Column(name = "venduta", columnDefinition = "false")
    private Boolean isVentuta;

    //    manyToOne con concessionario
    @ManyToOne
    @JoinColumn(name = "concessionario_id")
    @JsonManagedReference
    private Concessionario concessionario;

    //    oneToOne con Clienti
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //    manyToMany con Motori
    @ManyToMany
    @JoinTable(

            name = "automobile_motore",
            joinColumns = @JoinColumn(name = "automobile_id"),
            inverseJoinColumns = @JoinColumn(name = "motore_id")
    )
    @JsonManagedReference
    private List<Motore> motori;

    //    manyToMany con Accessori
    @ManyToMany
    @JoinTable(
            name = "accessorio_automobile",
            joinColumns = @JoinColumn(name = "automobile_id"),
            inverseJoinColumns = @JoinColumn(name = "accessorio_id")
    )
    @JsonManagedReference
    private List<Accessorio> accessori;

}
