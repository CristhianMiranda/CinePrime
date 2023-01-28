package co.edu.uniquindio.cineprime.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Confiteria  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;


    @Column(length = 80,nullable = false)
    @NotBlank
    private String nombre;

    @Positive
    @Column(nullable = false)
    private Float precio;

    @Column(nullable = false)
    @NotBlank
    private String url_Imagen;


   /* @OneToMany(mappedBy = "confiteria")
    private List<CompraConfiteria> comprasConfiteria;*/
}
