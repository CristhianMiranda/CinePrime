package co.edu.uniquindio.cineprime.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompraConfiteria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Positive
    @Column(nullable = false)
    private Float valorTotal;

    private int unidades;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;

    /*@ManyToOne
    @JoinColumn(nullable = false)
    private Confiteria confiteria;*/
}
