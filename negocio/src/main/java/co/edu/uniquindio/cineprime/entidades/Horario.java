package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String dia;

    @Column(nullable = false)
    private String hora;

    @Column(nullable = false)
    private String fechaInicio;

    @Column(nullable = false)
    private String fechaFin;


    @Builder

    public Horario(String dia, String hora, String fechaInicio, String fechaFin) {
        this.dia = dia;
        this.hora = hora;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

}
