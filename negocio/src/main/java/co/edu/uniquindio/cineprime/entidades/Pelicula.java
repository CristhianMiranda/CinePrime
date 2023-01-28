package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;


    @Column(nullable = false)
    @NotBlank
    @ToString.Include
    private String nombre;

    @Column(nullable = false)
    @NotBlank
    private String sipnosis;


    @Column(nullable = false)
    @NotBlank
    private String url_Trailer;


    @Column(nullable = false)
    @NotBlank
    private String url_Imagen;

   @Column(nullable = false)
    @NotBlank
    private String estado;

    @Column(nullable = false)
    @NotBlank
    private String reparto;

    public Pelicula(int codigo, String nombre, String sipnosis, String url_Trailer, String url_Imagen, String estado, String reparto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sipnosis = sipnosis;
        this.url_Trailer = url_Trailer;
        this.url_Imagen = url_Imagen;
        this.estado = estado;
        this.reparto = reparto;
    }
}
