package co.edu.uniquindio.cineprime.servicios;

import co.edu.uniquindio.cineprime.entidades.*;
import org.springframework.data.jpa.repository.Query;

public interface AdministradorTeatroServicio {


    AdministradorTeatro verificarLogin(String correo, String contraseña) throws Exception;

    Funcion registrarFuncion(Funcion funcion) throws Exception;

    Funcion actualizarFuncion(Funcion funcion) throws Exception;

    void elimiarFuncion(int codigoFuncion) throws Exception;

    Funcion buscarFuncionCodigo(int codigoFuncion) throws Exception;

    Sala buscarSalaCodigo(int codigoSala) throws Exception;

    Horario buscarHorarioCodigo(int codigohorario) throws Exception;

    Pelicula obtenerPeliculaCodigo(int codigoPelicula) throws Exception;


    Teatro registrarTeatro(Teatro teatro) throws Exception;

    Teatro actualizarTeatro(Teatro teatro) throws Exception;

    void eliminarTeatro(int codigoTeatro) throws Exception;

    Teatro buscarTeatroCodigo(int codigoTeatro) throws Exception;

    Ciudad buscarCiudadCodigo(int codigo);

}
