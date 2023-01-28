package co.edu.uniquindio.cineprime.entidades;

import lombok.*;

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
@ToString
public class Cupon implements Serializable {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String codigo;

    private String descripcion;

    @Positive
    @Column(nullable = false)
    private Float descuento;

    private String criterio;

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @OneToMany(mappedBy = "cupon")
    private List<CuponUsuario> cupones;


    @Column(nullable = false)
    private boolean reclamado;


   /* @OneToOne
    private Compra compra;
    */
//    @Column(nullable = false)
//    private Boolean estado;

//    @OneToOne(mappedBy = "cupon")
//    private Compra compra;

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Usuario usuario;

    @Builder

    public Cupon(Float descuento, LocalDate fechaVencimiento, Boolean estado, Usuario usuario) {
        this.descuento = descuento;
        this.fechaVencimiento = fechaVencimiento;
//        this.estado = estado;
//        this.usuario = usuario;
    }
}
