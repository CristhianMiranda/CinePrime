package co.edu.uniquindio.cineprime.servicios;

import co.edu.uniquindio.cineprime.entidades.*;

import java.util.ArrayList;
import java.util.List;

public interface    UsuarioServicio {


    ArrayList<Pelicula> encontrarPeliculas(String nombre) throws Exception;

    ArrayList<Pelicula> listarPeliculas();

    /**
     * Método para registrar usuario
     * @param cedula Es la id del usuario este debe ser único
     * @param email es el correo del usuario y debe ser único
     * @param contrasena esta es la contraseña del usuario asociada a la cuenta del usuario
     * @param nombre corresponde al nombre digitado por el usuario
     * @return
     * @throws Exception
     */
    Usuario registrarUsuario(int cedula,String email,String contrasena,String nombre) throws Exception;

    Cupon crearBono(float cantidad,String criterio,String descripcion,Boolean usuarioNuevo);

    TarjetaCinePrime crearTarjetaCinePrime();
    void usarCupon(Cupon cupon,Usuario usuario) throws Exception;

    void realizarCompra(Usuario usuario,Funcion funcion,CuponUsuario cuponUsuario);
    CuponUsuario encontrarCuponUsuario(int codigo);

    List<Compra> listarCompras(int cedula);
    Funcion obtenerFuncionCodigo(int codigo);
    Usuario verificarLogin(String email, String contrasena) throws Exception;

    void asociarTarjetaCinePrime(Usuario usuario,TarjetaCinePrime tarjetaCinePrime);

    /**NOINOSNOSNOSNOS
     * Metodo para recuperar la contraseña de la cuenta de usuario con el correo
     * @param email correo de cuenta de usuario
     * @return contraseña de cuenta
     * @throws Exception no existe el correo asociada a ninguna cuenta
     */
    void recuperarContrasenaCorreo(String email) throws Exception;


















    ArrayList<Usuario> obtenerUsuarios();
    Usuario guardarUsuario(Usuario usuario) throws Exception;

    Usuario obtenerPorCedula(int cedula) throws Exception;

    boolean eliminarUsuario(int id);

    Cupon buscarCupon(String codigo) throws  Exception;



}
