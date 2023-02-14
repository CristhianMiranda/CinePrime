package co.edu.uniquindio.cineprime.entidades;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

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


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotBlank
   /* @DateTimeFormat(pattern = "dd-MMM-yyyy")*/
    private Date estreno;

    @NotBlank
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Genero genero;


    @NotBlank
    @Column(nullable = false)
    private int restriccionEdad;

    @NotBlank
    @Column(nullable = false)
    private int duracionPelicula;

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
