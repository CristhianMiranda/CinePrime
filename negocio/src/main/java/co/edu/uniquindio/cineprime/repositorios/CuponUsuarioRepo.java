package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.Cupon;
import co.edu.uniquindio.cineprime.entidades.CuponUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuponUsuarioRepo extends JpaRepository<CuponUsuario,String> {
    @Query("select c from CuponUsuario c where c.codigo =:codigo")
    CuponUsuario encontrarCupon(int codigo);

    @Query("select c from CuponUsuario c where c.usuario.cedula =:cedulaUsuario")
    List<CuponUsuario> listaCupones (int cedulaUsuario);
}
