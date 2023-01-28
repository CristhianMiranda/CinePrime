package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bono implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @ToString.Include
    private String cifrado;

    private int porcentaje;


    @Column(nullable = false)
    private boolean usado;

}
