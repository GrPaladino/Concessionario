package main.java.com.app.concessionario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "concessionari")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Concessionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "indirizzo", length = 200)
    private String indirizzo;

    @Column(name = "p_iva", length = 11, nullable = false, unique = true)
    private String p_iva;
}
