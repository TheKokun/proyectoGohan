package com.proyectoGohan.proyectoGohan.Service;

import com.proyectoGohan.proyectoGohan.Entity.Persona;
import com.proyectoGohan.proyectoGohan.Entity.Respuestas;
import com.proyectoGohan.proyectoGohan.Repository.QuestionarioRepository;
import com.proyectoGohan.proyectoGohan.Repository.RespuestasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestasService {


    private final RespuestasRepository respuestasRepository;

    @Autowired
    public RespuestasService(RespuestasRepository respuestasRepository) {
        this.respuestasRepository = respuestasRepository;
    }
    public Respuestas guardarRespuestas(String respuestasJson, Persona persona) {
        Respuestas respuestas = new Respuestas(respuestasJson, persona);
        return respuestasRepository.save(respuestas);
    }

    public List<Respuestas> obtenerRespuestasPorNombre(String nombre) {
        // Implementa la lógica de la consulta por nombre en el repositorio
        return respuestasRepository.findByPersonaNombreContaining(nombre);
    }
}
