package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 10)
    @ToString.Include
    private MedioPago medioPago;

    @Column(nullable = false)
    @ToString.Include
    private LocalDateTime fecha;

    @Positive
    @Column(nullable = false)
    @ToString.Include
    private Float valorTotal;
/*
    @ManyToMany
    private List<Confiteria> confiteria;
*/
    @OneToOne
    @ToString.Include
    private Cupon cupon;

    @NotNull
    @ManyToOne
    @ToString.Include
    private Funcion funcion;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;



/*
    @OneToMany(mappedBy = "compra")
    @JoinColumn(nullable = true)
    private List<CompraConfiteria> comprasConfiteria;*/
/*
    @ManyToMany
    @JoinColumn(name = "entrada" ,
            joinColumns = @JoinColumn(name = "compra_codigo") ,
            inverseJoinColumns = @JoinColumn(name = "silla_sala_codigo")
    )
    private List<SillaSala> sillaSala;
*/
    public Compra(MedioPago medioPago, LocalDateTime fecha, List<Confiteria> confiteria, Cupon cupon, Usuario usuario, Funcion funcion, List<SillaSala> sillaSala) {
        this.medioPago = medioPago;
        this.fecha = fecha;
      //  this.confiteria = confiteria;
        this.cupon = cupon;
        this.usuario = usuario;
        this.funcion = funcion;
      //  this.sillaSala = sillaSala;
    }
}
