package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Funcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Positive
    @Column(nullable = false)
    private Float precio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Horario horario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Sala sala;

    @OneToMany(mappedBy = "funcion")
    private List<Compra> compras;

    @Builder
    public Funcion(Sala sala, Horario horario, Pelicula pelicula) {

        this.sala = sala;
        this.horario = horario;
        this.pelicula = pelicula;
    }
    /*
    @Builder

    public Funcion(Sala sala, Horario horario, Pelicula pelicula) {
        this.sala = sala;
        this.horario = horario;
        this.pelicula = pelicula;
    }
    */

}
