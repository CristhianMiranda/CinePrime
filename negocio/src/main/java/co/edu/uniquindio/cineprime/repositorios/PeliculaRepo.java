package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula,String> {

    @Query("select p.nombre from Pelicula p where p.nombre = :nombre")
    Pelicula ObtenerPelicula(String nombre);

    @Query("select p from Pelicula p where p.codigo = :codigo")
    Pelicula ObtenerPelicula(int codigo);

    @Query("select p from Pelicula p ")
    List<Pelicula> listarPeliculas();


    /*
    * @Query("select p from Pelicula p ORDER BY CASE WHEN p.estado ='Pre-estreno' THEN 1" +
            " WHEN p.estado = 'Estreno' THEN 2" +
            "ELSE 3 END,p.estado")*/








}
