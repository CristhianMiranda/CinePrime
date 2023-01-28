package co.edu.uniquindio.cineprime.repositorios;


import co.edu.uniquindio.cineprime.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra,String> {

    @Query("select c from Compra c where c.usuario.cedula =:cedula")
    List<Compra> listarCompras(int cedula);
}
