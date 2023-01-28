package co.edu.uniquindio.cineprime.servicios;

import co.edu.uniquindio.cineprime.entidades.*;
import co.edu.uniquindio.cineprime.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    private final UsuarioRepo usuarioRepo;
    private final PeliculaRepo peliculaRepo;

    private final CuponRepo cuponRepo;

    private final CuponUsuarioRepo cuponUsuariosRepo;


    private final EmailServiceRecuperacionContrasena emailServiceRecuperacionContrasena;

    private final EmailService emailService;

    private final CompraRepo compraRepo;

    private final FuncionRepo funcionRepo;

    private final TarjetaCinePrimeRepo tarjetaCinePrimeRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo, PeliculaRepo peliculaRepo, CuponRepo cuponRepo, CuponUsuarioRepo cuponUsuariosRepo, EmailServiceRecuperacionContrasena emailServiceRecuperacionContrasena, EmailService emailService, CompraRepo compraRepo, FuncionRepo funcionRepo, TarjetaCinePrimeRepo tarjetaCinePrimeRepo) {
        this.usuarioRepo = usuarioRepo;

        this.peliculaRepo = peliculaRepo;
        this.cuponRepo = cuponRepo;
        this.cuponUsuariosRepo = cuponUsuariosRepo;
        this.emailServiceRecuperacionContrasena = emailServiceRecuperacionContrasena;
        this.emailService = emailService;
        this.compraRepo = compraRepo;
        this.funcionRepo = funcionRepo;
        this.tarjetaCinePrimeRepo = tarjetaCinePrimeRepo;
    }

    public Boolean coincidencia (String[] objeto, String[] buscado)
    {
       // int j=0;
        for(int j=0;j< buscado.length;j++) {
            for (int i = 0; i < objeto.length; i++) {
               // System.out.println(buscado[j].toLowerCase()+objeto[i].toLowerCase());
                if (buscado[j].toLowerCase().equals(objeto[i].toLowerCase()) ) {
                    return true;
                }

            }
        }
        return false;
    }

    @Override
    public ArrayList<Pelicula> encontrarPeliculas(String nombre) throws Exception {

        ArrayList<Pelicula> peliculasCoincididas = new ArrayList<>();


        for (int i=0;i<peliculaRepo.listarPeliculas().size();i++)
        {
            int k = cantidadEspacios(peliculaRepo.listarPeliculas().get(i).getNombre());

            for(int j = 0;j<=k;j++)
            {
                String[] palabrasPelicula = peliculaRepo.listarPeliculas().get(i).getNombre().split(" ");
                String[] palabrasBusqueda = nombre.split(" ");

                if(coincidencia(palabrasPelicula,palabrasBusqueda))
                {

                    peliculasCoincididas.add(peliculaRepo.listarPeliculas().get(i));

                    break;
                }
            }


        }
        if(peliculasCoincididas.isEmpty())
        {
            throw new Exception("No hay Coincidencias");
        }else {
            System.out.println(peliculasCoincididas.toString());
        }


        return peliculasCoincididas;

    }
    public int cantidadEspacios(String cadena)
    {
        int aux=0;
        for (int i =0;i<cadena.length();i++)
        {

            if(' '==(cadena.charAt(i)))
            {
                aux++;
            }

        }

        return aux;
    }

    @Override
    public Usuario registrarUsuario(int cedula, String email, String contrasena, String nombre) throws Exception {
        Usuario usuario = new Usuario();

        usuario.setContraseña(contrasena);

        usuario.setNombre(nombre);
       // usuario.setEmail(email);
        //usuario.setCiudad(ciudadRepo.obtenerCiudadCodigo(codigoCiudad));

        usuario.setCiudad(null);

        /**
         * Método para verificar si la cedula esta registrada a otro usuario y tambien para ver si es valida
         */
        if(usuarioRepo.obtenerUsuarioCedula(cedula)!=(null)) {

            throw new Exception("La cédula ya esta registrada a un usuario");
        }else {

            if (String.valueOf(cedula).length() > 6 && String.valueOf(cedula).length() < 11) {
                System.out.println(String.valueOf(cedula).length());
                usuario.setCedula(cedula);

            } else {

                throw new Exception("Tu cédula no corresponde a ningún formato permitido, " +
                        "Este debería ser: " +
                        "XXXXXXX (1920)/(2001)          " +
                        "XXXXXXXXXX(2002)/(Vigente)");

            }
        }


        /**
         * Metodo para encapsular todas las excepciones posibles de un valor de email
         */
        if (obtenerUsuarioCorreo(email) != null) {
            throw new Exception("El correo ya esta registrado");

        } else {

            /**
             * If para verificar que el correo no este vacío y anidado más if para verificar más tipos de correos erróneos.
             */
            if (email != "") {
                int aux = 0;


                /**
                 * For para analizar todo el correo caracter por caracter y verificar que tenga por lo menos un . y @
                 */
                for (int i = 0; i < email.length(); i++) {


                    if (email.charAt(i) == '@') {
                        aux++;
                        // usuario.setEmail(email);
                    }

                    if (email.charAt(i) == '.') {
                        aux++;
                        // usuario.setEmail(email);
                    }

                }


                /**
                 * Método para guardar el correo después de haber pasado por procesos de verificación.
                 */
                if (aux == 2) {

                    usuario.setEmail(email);
                       /* String codigoGenerado=generarCodigoPuntos();
                        registrarPuntosUsuario(codigoGenerado,15,usuarioRepo.save(usuario));
                       */
                   // crearBono(15);

                    /**
                     * Try/Catch para verificar si la sintaxis del correo finalmente corresponde a un correo real

                    try {

                        enviarCorreo("Bienvenido a unitravel",generarCodigoPuntos(), email, nombre);

                    } catch (Exception e) {

                        throw new Exception("Tu correo no sigue la estructura micorreo@dominio.organizacion");

                    }
                     */
                    Cupon cupon =  crearBono(10,"Primer Registro","",true);
                    enviarCorreo("Activa tu cuenta", cupon.getCodigo(), usuario.getEmail(),usuario.getNombre(), (int) (0+cupon.getDescuento()));
                  // enviarCorreoRecuperacion("Activa tu cuenta",usuario.getContraseña(), usuario.getEmail(),"aversas"/*usuarioRepo.recuperarContrasena(email).getContraseña()*/);
                    usuario.setActivacion(false);
                    return usuarioRepo.save(usuario);

                }else {
                    throw  new Exception("Tu correo no sigue la estructura");
                }
            } else {

                throw new Exception("Tu correo no puede estar vació, Sigue la estructura micorreo@dominio.organizacion");

            }

        }

    }


    /**
     * Metodo para enviar correo
     * @param asunto encabezado de correo
     * @param contenido información que se quiere enviar
     * @param destinatario correo de persona que recibir su información
     * @param datos Es otro dato diferente al correo del usuario
     */
    public void enviarCorreo(String asunto,String contenido,String destinatario,String datos,int descuento)
    {
        boolean estado = emailService.enviarEmail(asunto, contenido, destinatario,datos,descuento);
    }
    public void enviarCorreoRecuperacion(String asunto,String contenido,String destinatario,String datos)
    {
        boolean estado = emailServiceRecuperacionContrasena.enviarEmail(asunto,contenido,destinatario,datos);
    }


    /**
     * Método para obtener un usuario con un correo digitado
     * @param email correo del usuario
     * @return usuario asociado a ese correo
     */
    public  Usuario obtenerUsuarioCorreo(String email)
    {
        return usuarioRepo.findAllByEmail(email).orElse(null);
    }

    @Override
    public TarjetaCinePrime crearTarjetaCinePrime()
    {
        TarjetaCinePrime tarjetaCinePrime = new TarjetaCinePrime();
        tarjetaCinePrime.setDescuento(20F);
        tarjetaCinePrime.setFechaVencimiento(LocalDate.now().plusYears(1));
        tarjetaCinePrime.setCodigo(generarCodigoPuntos());

        return tarjetaCinePrimeRepo.save(tarjetaCinePrime);
    }

    @Override
    public void asociarTarjetaCinePrime(Usuario usuario,TarjetaCinePrime tarjetaCinePrime)
    {
        usuario.setTarjetaCinePrime(tarjetaCinePrime);
        usuarioRepo.save(usuario);
    }
    @Override
    public Cupon crearBono(float cantidad,String criterio,String descripcion,Boolean usuarioNuevo) {

        Cupon cupon = new Cupon();
        cupon.setCodigo(generarCodigoPuntos());
        cupon.setDescuento(cantidad);
        cupon.setCriterio("Cupon "+criterio/*"Cupon Navideño"*/);
        cupon.setReclamado(false);
        System.out.println(usuarioNuevo);
        if(usuarioNuevo)
        {

            if(descripcion=="" )
            {
                cupon.setDescripcion("Cupon de "+(int)cantidad+"% "+"de descuento valido hasta "+LocalDate.now().plusMonths(1).toString());
            }else {
                cupon.setDescripcion("Cupon de "+(int)cantidad+"% "+"de descuento, "+descripcion+ ". valido hasta "+LocalDate.now().plusMonths(1).toString()/*"Cupon de 20% de descuento en cualquier funcion, valido hasta 31/12/2020"*/);

            }

            cupon.setFechaVencimiento(LocalDate.now().plusMonths(1));

            return cuponRepo.save(cupon);
        }else {
            if(descripcion=="" )
            {
                cupon.setDescripcion("Cupon de "+(int)cantidad+"% "+"de descuento valido hasta "+LocalDate.now().plusYears(1).toString());
            }else {
                cupon.setDescripcion("Cupon de "+(int)cantidad+"% "+"de descuento, "+descripcion+ ". valido hasta "+LocalDate.now().plusYears(1).toString()/*"Cupon de 20% de descuento en cualquier funcion, valido hasta 31/12/2020"*/);

            }
            cupon.setFechaVencimiento(LocalDate.now().plusYears(1));
            return cuponRepo.save(cupon);
        }


    }
    public  String generarCodigoPuntos()
    {
        StringBuilder builder;
        String theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        builder = new StringBuilder(8);

        for (int m = 0; m < 8; m++) {

            // generate numeric
            int myindex
                    = (int)(theAlphaNumericS.length()
                    * Math.random());

            // add the characters
            builder.append(theAlphaNumericS
                    .charAt(myindex));
        }
        //System.out.println(builder.toString());
        return builder.toString();
    }
    @Override
    public void usarCupon(Cupon cupon,Usuario usuario) throws Exception {


        List<CuponUsuario> cuponUsuarios = new ArrayList<>() ;
        System.out.println(usuario.getCedula());

            System.out.println(cupon.getFechaVencimiento().toString() + LocalDate.now() + "xd" + cupon.getFechaVencimiento().isAfter(LocalDate.now()));

        //  cuponClientes.;
        if(cupon.isReclamado())
        {
            throw new Exception("El cupon esta usado");
        }else  if(!(cupon.getFechaVencimiento().isAfter(LocalDate.now())))
        {
            throw new Exception("El cupon esta Vencido");
        }
        CuponUsuario cuponUsuario = new CuponUsuario();
        cuponUsuario.setUsuario(usuario);
        cuponUsuario.setEstado(false);
        cuponUsuario.setCupon(cupon);
        cuponUsuarios.add(cuponUsuariosRepo.save(cuponUsuario));

        cupon.setReclamado(true);
        cupon.setCupones(cuponUsuarios);
        cuponRepo.save(cupon);

        usuario.setCuponesUsuario(cuponUsuarios);
        usuarioRepo.save(usuario);


        //
       // cupones.setCupon(cupon);
      //  cuponUsuarios.add();



            /*
            buscarBono(cifrado).setPuntos(puntos);
            buscarBono(cifrado).setUsado(true);
            BonoRepo
            */
        }

    @Override
    public void realizarCompra(Usuario usuario, Funcion funcion,CuponUsuario cuponUsuario) {
        Compra compra = new Compra();
        compra.setUsuario(usuario);
        compra.setMedioPago(MedioPago.DAVIPLATA);
        compra.setFecha(LocalDate.now().atStartOfDay());
        compra.setFuncion(funcion);

        if(cuponUsuario.equals(null)||cuponUsuario.getEstado()) {

            compra.setValorTotal(funcion.getPrecio());

        }else{
                cuponUsuario.setEstado(true);
                cuponUsuariosRepo.save(cuponUsuario);
                compra.setCupon(cuponUsuario.getCupon());
                compra.setValorTotal(funcion.getPrecio() - (funcion.getPrecio() * (cuponUsuario.getCupon().getDescuento()/100)));
            }


        if(usuario.getTarjetaCinePrime().equals(null)) {
            compra.setValorTotal(compra.getValorTotal());
        }else{
            compra.setValorTotal(compra.getValorTotal() -(compra.getValorTotal() * (usuario.getTarjetaCinePrime().getDescuento()/100)));
        }

       // compra.setValorTotal(funcion.getPrecio());

        compraRepo.save(compra);

    }



        /* System.out.println();
        if(buscarBono(cifrado)==null&&buscarBono(cifrado).isUsado())
        {
            throw new Exception("El bono no existe o ya ha sido usado.");
        }else {
        Puntos puntos = new Puntos();
        puntos.setCantidad(buscarBono(cifrado).getCantidad());
        puntos.setBono(buscarBono(cifrado));

        PuntosUsuario puntosUsuario = new PuntosUsuario();
        puntosUsuario.setPuntos(puntoRepo.save(puntos));
        puntosUsuario.setUsuario(usuario);
        puntosUsuarioRepo.save(puntosUsuario);
        buscarBono(cifrado).setPuntos(puntoRepo.save(puntos));
        buscarBono(cifrado).setUsado(true);
        }*/

    public Cupon buscarCupon(String codigo) throws Exception {
        try {
            if(!cuponRepo.buscarCuponCodigo(codigo).equals(null))
            {
                System.out.println("El cupon existe");
            }
        }catch (Exception e)
        {
            throw new Exception("No existe un cupon con este codigo");
        }





       if(cuponRepo.buscarCuponCodigo(codigo).isReclamado())
       {
           throw new Exception("Este Cupon ya a sido reclamado ");
       }


        return cuponRepo.buscarCuponCodigo(codigo);
    }

    public CuponUsuario encontrarCuponUsuario(int codigo)
    {
        return cuponUsuariosRepo.save(cuponUsuariosRepo.encontrarCupon(codigo));
    }

    @Override
    public List<Compra> listarCompras(int cedula) {
        return compraRepo.listarCompras(cedula);
    }

    @Override
    public Usuario verificarLogin(String email, String contrasena) throws Exception {

        Usuario usuario = new Usuario();
        if(obtenerUsuarioCorreo(email)==null)
        {

            throw  new Exception("El correo no corresponde a ningun usuario");

        }else {

            usuario= obtenerUsuarioCorreo(email);
            System.out.println(usuario.isActivacion()+"");
            if(usuario.getContraseña().equals(contrasena) && usuario.isActivacion())
            {
                System.out.println("El usuario se logeo correctamente");
                return usuario;


            }else
            {

                throw  new Exception("La contraseña es incorrecta o la cuenta no esta activada (verifica en tu correo un link)");

            }


        }
    }

    @Override
    public void recuperarContrasenaCorreo(String email) throws Exception{
        if(usuarioRepo.recuperarContrasena(email)==null)
        {
            throw new Exception("El correo no se encontro asociada a ninguna cuenta");
        }
        enviarCorreoRecuperacion("Recuperacion de contraseña",usuarioRepo.recuperarContrasena(email).getContraseña(),email,usuarioRepo.recuperarContrasena(email).getNombre());

        // return usuarioRepo.recuperarContrasena(email);
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return null;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        return null;
    }

    @Override
    public Usuario obtenerPorCedula(int cedula) throws Exception {

         try {
            if(!usuarioRepo.obtenerUsuarioCedula(cedula).equals(null))
            {
                System.out.println("Esta cedula esta asociada a una cuenta");
            }
         }catch (Exception e)
         {
             throw new Exception("Esta cedula no esta asociada a ninguna cuenta");
         }

        return  usuarioRepo.obtenerUsuarioCedula(cedula);

    }

    @Override
    public Funcion obtenerFuncionCodigo(int codigo) {

        return funcionRepo.save(funcionRepo.findAllByCodigo(codigo));

    }


    @Override
    public boolean eliminarUsuario(int id) {
        return false;
    }
}