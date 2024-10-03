package main.java.com.app.concessionario.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "potenza", nullable = false)
    private Integer potenza;

    @Column(name = "cilindrata", nullable = false)
    private Double cilindrata;

    @Column(name = "carburante", length = 20, nullable = false)
    private String carburante;

    //    manyToMany con Auto
    @ManyToMany
//    @JsonBackReference
    @JsonIgnore
    @JoinTable(

            name = "automobile_motore",
            joinColumns = @JoinColumn(name = "automobile_id"),
            inverseJoinColumns = @JoinColumn(name = "motore_id")
    )
    private List<Auto> auto;





}
