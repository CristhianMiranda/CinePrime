package co.edu.uniquindio.cineprime.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TarjetaCinePrime implements Serializable {
    @Id
    private String codigo;

    @OneToMany(mappedBy = "tarjetaCinePrime")
    private List<Usuario> usuarios;


    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Positive
    @Column(nullable = false)
    private Float descuento;
}
