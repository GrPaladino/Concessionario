package main.java.com.app.concessionario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "optionals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Optional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 20, nullable = false)
    private String nome;
}
