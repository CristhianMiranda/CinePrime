package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.DistribucionSillas;
import co.edu.uniquindio.cineprime.entidades.Funcion;
import co.edu.uniquindio.cineprime.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FuncionRepo extends JpaRepository<Funcion,String> {
    Funcion findAllByCodigo(int codigo);

    Optional<Funcion> findByCodigo(Integer codigo);

    @Query("select ds from Funcion f join f.sala.distribucionSillas ds where f.codigo = :codigoFuncion")
    DistribucionSillas obtenerDistribucionSillas(Integer codigoFuncion);

    @Query("select f from Funcion f where f.horario=:codigoHorario")
    List<Funcion> obtenerFuncionesHorario(Integer codigoHorario);

    @Query("select f from Funcion f where f.codigo=:codigoFuncion")
    Funcion obtenerFuncionCodigo(int codigoFuncion);

    @Query("select f from Funcion f join f.sala s where s.codigo=:codigoSala")
    List<Funcion> obtenerFuncionCodigoSala(int codigoSala);

    @Query("select f.sala from Funcion f where f.codigo=:codigoFuncion")
    Sala obtenerSalaFuncion(int codigoFuncion);


}
