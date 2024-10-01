package main.java.com.app.concessionario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "motori")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Motore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "potenza", nullable = false)
    private Integer potenza;

    @Column(name = "cilindrata", nullable = false)
    private Double cilindrata;

    @Column(name = "carburante", length = 20, nullable = false)
    private String carburante;

}
