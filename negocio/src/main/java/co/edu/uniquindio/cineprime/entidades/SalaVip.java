package co.edu.uniquindio.cineprime.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SalaVip implements Serializable {
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

}
