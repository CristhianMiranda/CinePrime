package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.TarjetaCinePrime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaCinePrimeRepo extends JpaRepository<TarjetaCinePrime,String> {
}
