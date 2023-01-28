package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.AdministradorTeatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorTeatroRepo extends JpaRepository<AdministradorTeatro, String> {
    @Query("select a from AdministradorTeatro  a where a.correo =:correo and a.contraseña =:contraseña")
    AdministradorTeatro verificarLogin(String correo, String contraseña);
}
