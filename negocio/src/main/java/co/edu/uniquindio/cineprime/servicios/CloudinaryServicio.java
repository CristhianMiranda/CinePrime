package co.edu.uniquindio.cineprime.servicios;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServicio {

    private Cloudinary cloudinary;
    private Map<String, String> config;

    public CloudinaryServicio()
    {
        config = new HashMap<>();
        config.put("cloud_name","dhis3g0ec");
        config.put("api_key","963593818797366");
        config.put("api_secret","IhDVPF5DFB5aOv1mKqzatT4TsHo");

        cloudinary = new Cloudinary(config);
    }

    public Map subirImagen(File file, String carpeta) throws IOException {
        Map respuesta = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",carpeta));
        return respuesta;

    }

    public Map eliminarImagen(String idImagen) throws IOException {
        Map respuesta= cloudinary.uploader().destroy(idImagen,ObjectUtils.emptyMap());
        return respuesta;
    }

}
