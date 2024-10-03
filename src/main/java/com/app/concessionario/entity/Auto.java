package main.java.com.app.concessionario.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "automobili")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    private String carrozzeria;

    @Column(name = "venduta", columnDefinition = "false")
    private Boolean isVentuta;

    //    manyToOne con concessionario
    @ManyToOne
    @JoinColumn(name = "concessionario_id")
    private Concessionario concessionario;

//    oneToOne con Clienti
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

//    manyToMany con Motori
    @ManyToMany(mappedBy = "auto")
//    @JsonManagedReference
    private List<Motore> motori;

    //    manyToMany con Accessori
    @ManyToMany(mappedBy = "auto")
//    @JsonManagedReference
    private List<Accessorio> accessori;

}
