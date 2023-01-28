package co.edu.uniquindio.cineprime.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DistribucionSillas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    private String esquema;

    private int totalSillas;

    private int filas;

    private int columnas;


    @OneToMany/*(mappedBy = "codigo")*/
    private List<SalaVip> salaVips;

    @OneToMany/*(mappedBy = "codigo")*/
    private List<Sala> sala;

}
