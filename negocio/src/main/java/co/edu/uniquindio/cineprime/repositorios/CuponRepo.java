package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuponRepo extends JpaRepository<Cupon,String> {

    @Query("select c from Cupon c where c.codigo = :codigo")
    Cupon buscarCuponCodigo (String codigo);

    @Query("delete  from Cupon c where c.codigo = :codigo")
    void eliminarBono(int codigo);
}