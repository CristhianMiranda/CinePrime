package co.edu.uniquindio.cineprime.entidades;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Persona implements Serializable {
    @ElementCollection
    private List<String> telefono;

    @JoinColumn( nullable = true)
    @Getter
    private boolean activacion;

    @ManyToOne
    @JoinColumn(name = "codigoCiudad", nullable = true)
    private Ciudad ciudad;

    @ToString.Include
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    @NotNull
    private int cedula;


    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;

    @OneToMany(mappedBy = "usuario")
    private List<CuponUsuario> cuponesUsuario;

    @ManyToOne
    @JoinColumn(name = "codigoTarjeta", nullable = true)
    private TarjetaCinePrime tarjetaCinePrime;

    public Usuario(String nombre, @Email String email, String contraseña, int cedula) {
        super(nombre, email, contraseña);
        this.cedula = cedula;
    }

}