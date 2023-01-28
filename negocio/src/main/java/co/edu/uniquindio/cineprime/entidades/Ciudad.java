package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;
/*
    @OneToMany(mappedBy = "ciudad")
    private List<Teatro> teatros;

*/
    //*@OneToMany
//    private List<Teatro> teatros;*/
    @OneToMany(mappedBy = "ciudad")
    private List<Teatro> teatros;

    @OneToMany(mappedBy="ciudad")
    private List<Usuario> usuarios;

    @Builder
    public Ciudad(String nombre){
        this.nombre = nombre;
    }

}
