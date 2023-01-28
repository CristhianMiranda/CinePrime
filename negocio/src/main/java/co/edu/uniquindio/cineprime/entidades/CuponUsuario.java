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
public class CuponUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cupon cupon;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;


    public CuponUsuario( Boolean estado, Cupon cupon, Usuario usuario) {

        this.estado = estado;
        this.cupon = cupon;
        this.usuario = usuario;
    }
}
