package main.java.com.app.concessionario.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    //    manyToMany con Auto
    @ManyToMany
//    @JsonBackReference
    @JsonIgnore
    @JoinTable(
            name = "automobile_optional",
            joinColumns = @JoinColumn(name = "automobile_id"),
            inverseJoinColumns = @JoinColumn(name = "optional_id")
    )
    private List<Auto> auto;
}
