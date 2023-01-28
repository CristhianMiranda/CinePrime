package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.Funcion;
import co.edu.uniquindio.cineprime.entidades.TarjetaCinePrime;
import co.edu.uniquindio.cineprime.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeatroRepo extends JpaRepository<Teatro,String> {

    @Query("select t from Teatro t where t.codigo=:codigoTeatro")
    Teatro obtenerTeatroCodigo(int codigoTeatro);
}
