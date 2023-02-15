package co.edu.uniquindio.cineprime;

import co.edu.uniquindio.cineprime.entidades.Cupon;
import co.edu.uniquindio.cineprime.entidades.Funcion;
import co.edu.uniquindio.cineprime.entidades.Usuario;
import co.edu.uniquindio.cineprime.servicios.EmailService;
import co.edu.uniquindio.cineprime.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
//@Transactional

public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private EmailService emailService;

/*
    @Test
    //@Sql("classpath:dataset.sql")
    public void encontrarPelicula()  {
        try {
            usuarioServicio.encontrarPeliculas("dragon");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

 */

    @Test
    public void crearCupon(){
        Cupon cupon;
        cupon = usuarioServicio.crearBono(20.0F,"navidadeño","",false);
    }

    @Test
    public void usarCupon() throws Exception {

        try {
            usuarioServicio.usarCupon(usuarioServicio.buscarCupon("SBJOSNHX"), usuarioServicio.obtenerPorCedula(1010125168));

        }catch (Exception e)

        {
            e.printStackTrace();
        }
    }

/*
    @Test
    //@Sql("classpath:dataset.sql")
    public void compra() throws Exception {
        Funcion funcion = new Funcion();
       usuarioServicio.realizarCompra(usuarioServicio.obtenerPorCedula(1010125168),usuarioServicio.obtenerFuncionCodigo(1),usuarioServicio.encontrarCuponUsuario(1));
    }
*/
    /*
    @Test
    public void asociarTarjetaCinePrime() throws Exception {
        usuarioServicio.asociarTarjetaCinePrime(usuarioServicio.obtenerPorCedula(1010125168),usuarioServicio.crearTarjetaCinePrime());
    }

*/



    /**
     * Test para registrar un usuario
     */
    @Test
    public void registrarUsuario() {
        Usuario usuario = new Usuario();
        try {
            usuario= usuarioServicio.registrarUsuario(1010125168,"cristhianmirandapro@gmail.com","andres12","Cristhian Miranda");
            Assertions.assertNotNull(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void recuperarContrasenaTest() throws Exception {
        try {
            usuarioServicio.recuperarContrasenaCorreo("cristhianmirandapro@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listarCompras()
    {
        usuarioServicio.listarCompras(1010125168).forEach(System.out::println);
    }

    @Test
    public void verificarLoginTest()
    {
        try {

            usuarioServicio.verificarLogin("cristhianmirandapro@gmail.com","andres12");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
