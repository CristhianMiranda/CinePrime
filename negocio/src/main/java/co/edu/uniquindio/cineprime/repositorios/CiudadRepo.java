package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.Ciudad;
import co.edu.uniquindio.cineprime.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CiudadRepo extends JpaRepository<Ciudad,String> {
    @Query("select c from Ciudad c where c.codigo =:codigo")
    Ciudad buscarCiudadCodigo(int codigo);
}
