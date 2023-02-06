package co.edu.uniquindio.cineprime.controllers;


import co.edu.uniquindio.cineprime.entidades.Pelicula;
import co.edu.uniquindio.cineprime.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UsuarioApi {

    @Autowired
    UsuarioServicio usuarioServicio;


    @GetMapping("/saludar")
    public String saludar(){
        return "Hola mundo desde spring";
    }

    @GetMapping("/browser/{nombre}")
    public ArrayList<Pelicula> buscador(@PathVariable ("nombre") String nombre) throws Exception {
        return usuarioServicio.encontrarPeliculas(nombre);
    }
}
