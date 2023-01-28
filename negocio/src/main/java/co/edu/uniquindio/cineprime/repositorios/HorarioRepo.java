package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {

    Optional<Horario> findByCodigo(int codigo);
}
