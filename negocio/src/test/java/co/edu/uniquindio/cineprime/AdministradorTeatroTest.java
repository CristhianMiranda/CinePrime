package co.edu.uniquindio.cineprime;


import co.edu.uniquindio.cineprime.entidades.*;
import co.edu.uniquindio.cineprime.servicios.AdministradorTeatroServicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
//@Transactional
public class AdministradorTeatroTest {


    @Autowired
    private AdministradorTeatroServicio administradorTeatroServicio;


    @Test
    public void verificarLoginTest()
    {
        try {
            AdministradorTeatro admin = administradorTeatroServicio.verificarLogin("roxelito@yopmail.com","sosaleto");
            Assertions.assertNotNull(admin);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void registrarFuncionTest() throws Exception {


        try {

            Funcion funcion= new Funcion(administradorTeatroServicio.buscarSalaCodigo(1),administradorTeatroServicio.buscarHorarioCodigo(1),administradorTeatroServicio.obtenerPeliculaCodigo(1));
            funcion.setPrecio(20000F);
            //funcion.setCodigo(1);
            administradorTeatroServicio.registrarFuncion(funcion);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Test
    public void actualizarFuncionTest() throws Exception {
        Funcion funcion = administradorTeatroServicio.buscarFuncionCodigo(1);
        funcion.setPrecio(50000F);
    administradorTeatroServicio.actualizarFuncion(funcion);
    }

    @Test
    public void eliminarFuncionTest() throws Exception {
        administradorTeatroServicio.elimiarFuncion(1);
    }


    @Test
    public void registrarTeatroTest() throws Exception {


        try {

           Teatro teatro= new Teatro();
           teatro.setDireccion("Norte");
           teatro.setTelefono("3222594412");
           teatro.setAdministrador(administradorTeatroServicio.verificarLogin("roxelito@yopmail.com","sosaleto"));
           teatro.setCiudad(administradorTeatroServicio.buscarCiudadCodigo(1));

            //funcion.setCodigo(1);
            administradorTeatroServicio.registrarTeatro(teatro);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Test
    public void actualizarTeatroTest() throws Exception {
        Teatro teatro = administradorTeatroServicio.buscarTeatroCodigo(2);

        teatro.setTelefono("3225465982");
        administradorTeatroServicio.actualizarTeatro(teatro);
    }


    @Test
    public void eliminarTeatroTest() throws Exception {
        administradorTeatroServicio.eliminarTeatro(2);
    }
    


}
