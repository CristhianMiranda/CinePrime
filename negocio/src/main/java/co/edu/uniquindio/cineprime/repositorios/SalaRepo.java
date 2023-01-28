package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.Funcion;
import co.edu.uniquindio.cineprime.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalaRepo extends JpaRepository<Sala, Integer> {

  /*  @Query("select s from Sala s where s.tipoSala=:tiposala")
    List<Sala> obtenerSalasPortipo(TipoSala tipoSala);*/

    @Query("select s from Sala s where s.distribucionSillas=:distribucion")
    List<Sala> obtenerSalasPorDistribucion(Integer distribucion);

    @Query("select s from Sala s where s.codigo =:codigoSala")
    Sala obtenerSalaPorCodigo(int codigoSala);



    Optional<Sala> findByCodigo(Integer integer);
}