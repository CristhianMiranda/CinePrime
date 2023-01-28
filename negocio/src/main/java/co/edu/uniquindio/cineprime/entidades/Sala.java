package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "codigoDistribuccion", nullable = true)
    private DistribucionSillas distribucionSillas;

    @ManyToOne
    @JoinColumn(name = "codigoTeatro", nullable = true)
    private Teatro teatro;

    @ToString.Exclude
    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;


    @Builder
    public Sala(String nombre, Teatro teatro,  DistribucionSillas distribucionSillas) {
        this.nombre = nombre;
        this.teatro = teatro;
        this.distribucionSillas = distribucionSillas;
    }
}
