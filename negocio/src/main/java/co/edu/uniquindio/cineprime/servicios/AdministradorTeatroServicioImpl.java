package co.edu.uniquindio.cineprime.servicios;

import co.edu.uniquindio.cineprime.entidades.*;
import co.edu.uniquindio.cineprime.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorTeatroServicioImpl implements AdministradorTeatroServicio{

    private final AdministradorTeatroRepo administradorTeatroRepo;
    private final FuncionRepo funcionRepo;

    private final SalaRepo salaRepo;

    private final PeliculaRepo peliculaRepo;
    private final HorarioRepo horarioRepo;

    private final TeatroRepo teatroRepo;

    private final CiudadRepo ciudadRepo;

    public AdministradorTeatroServicioImpl(AdministradorTeatroRepo administradorTeatroRepo, FuncionRepo funcionRepo, SalaRepo salaRepo, PeliculaRepo peliculaRepo, HorarioRepo horarioRepo, TeatroRepo teatroRepo, CiudadRepo ciudadRepo) {
        this.administradorTeatroRepo = administradorTeatroRepo;
        this.funcionRepo = funcionRepo;
        this.salaRepo = salaRepo;
        this.peliculaRepo = peliculaRepo;
        this.horarioRepo = horarioRepo;
        this.teatroRepo = teatroRepo;
        this.ciudadRepo = ciudadRepo;
    }


    @Override
    public AdministradorTeatro verificarLogin(String correo, String contraseña) throws Exception {

        AdministradorTeatro administradorTeatro = administradorTeatroRepo.verificarLogin(correo, contraseña);

        if(administradorTeatro == null){
            throw new Exception("Los datos de login son incorrectos");
        }else {
            System.out.println("Administrador de teatro logueado correctamente");
        }
        return administradorTeatro;
    }

    @Override
    public Funcion registrarFuncion(Funcion funcion) throws Exception {
        return funcionRepo.save(funcion);
    }

    @Override
    public Funcion actualizarFuncion(Funcion funcion) throws Exception {
        return funcionRepo.save(funcion);
    }

    @Override
    public void elimiarFuncion(int  codigoFuncion) throws Exception {
        funcionRepo.delete(buscarFuncionCodigo(codigoFuncion));
    }

    @Override
    public Funcion buscarFuncionCodigo(int codigoFuncion)throws Exception {
        Funcion funcion = funcionRepo.obtenerFuncionCodigo(codigoFuncion);
        if(funcion==null){
            throw new Exception("La Funcion no se encontro");
        }
        return funcion;

    }

    @Override
    public Sala buscarSalaCodigo(int  codigoSala) throws Exception {
        Sala sala1 = salaRepo.obtenerSalaPorCodigo(codigoSala);
        if(sala1!=null){
            return sala1;
        }
        throw new Exception("Sala no existe");
    }

    @Override
    public Horario buscarHorarioCodigo(int  codigohorario) throws Exception {
        Optional<Horario> horario = horarioRepo.findByCodigo(codigohorario);
        if(horario.isEmpty()){
            throw new Exception("Sala no existe");
        }
        return horario.get();
    }

    @Override
    public Pelicula obtenerPeliculaCodigo(int codigoPelicula) throws Exception {

        if( peliculaRepo.ObtenerPelicula(codigoPelicula).equals(null)){
            throw new Exception("La pelicula no se encontro");
        }
        return  peliculaRepo.ObtenerPelicula(codigoPelicula);
    }

    @Override
    public Teatro registrarTeatro(Teatro teatro) throws Exception {
        return teatroRepo.save(teatro);
    }

    @Override
    public Teatro actualizarTeatro(Teatro teatro) throws Exception {
        return teatroRepo.save(teatro);
    }

    @Override
    public void eliminarTeatro(int codigoTeatro) throws Exception {
        teatroRepo.delete(buscarTeatroCodigo(codigoTeatro));
    }

    @Override
    public Teatro buscarTeatroCodigo(int codigoTeatro)throws Exception {
        Teatro teatro = teatroRepo.obtenerTeatroCodigo(codigoTeatro);
        if(teatro==null){
            throw new Exception("La Funcion no se encontro");
        }
        return teatro;

    }

    @Override
    public Ciudad buscarCiudadCodigo(int codigo) {
        return ciudadRepo.buscarCiudadCodigo(codigo);
    }
}
