package co.edu.uniquindio.cineprime.repositorios;

import co.edu.uniquindio.cineprime.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {
    @Query("select u.email from Usuario u where u.email = :email")
    Usuario obtenerEmail(String email);


    @Query("select u from Usuario u where u.email = :email")
    Usuario recuperarContrasena(String email);

    @Query("select u from Usuario u where u.cedula =:cedula")
    Usuario obtenerUsuarioCedula(int cedula);

    Optional<Usuario> findAllByEmail(String email);



}
