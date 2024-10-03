package main.java.com.app.concessionario.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "concessionarioId")
    private Concessionario concessionario;

//    oneToOne con Clienti
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

//    manyToMany con Motori
    @ManyToMany(mappedBy = "auto")
//    @JsonManagedReference
    private List<Motore> motori;

    //    manyToMany con Optional
    @ManyToMany(mappedBy = "auto")
//    @JsonManagedReference
    private List<Optional> optionals;

}
