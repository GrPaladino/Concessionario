package main.java.com.app.concessionario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "automibili")
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

    @Column(name = "modello", length = 50, nullable = false)
    private String modello;

    @Column(name = "colore", length = 20)
    private String colore;

    @Column(name = "stato", nullable = false, columnDefinition = "nuova")
    private String stato;

    @Column(name = "carrozzeria")
    private String carrozzeria;

    @Column(name = "venduta", nullable = false, columnDefinition = "false")
    private Boolean isVentuta;
}
