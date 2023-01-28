package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Entrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    @ToString.Exclude
    private int precio;

    @Column(nullable = false)
    private char fila;

    @Column(nullable = false)
    private int columna;

    @ToString.Exclude
    @ManyToOne
    private Compra compra;

    public Entrada(int codigo, int precio, char fila, int columna) {
        this.codigo = codigo;
        this.precio = precio;
        this.fila = fila;
        this.columna = columna;
    }
}
