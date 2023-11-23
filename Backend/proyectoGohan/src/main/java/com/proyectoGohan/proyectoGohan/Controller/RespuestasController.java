package com.proyectoGohan.proyectoGohan.Controller;

import com.proyectoGohan.proyectoGohan.Dto.RespuestasDto;
import com.proyectoGohan.proyectoGohan.Entity.Persona;
import com.proyectoGohan.proyectoGohan.Entity.Questionario;
import com.proyectoGohan.proyectoGohan.Entity.Respuestas;
import com.proyectoGohan.proyectoGohan.Service.QuestionarioService;
import com.proyectoGohan.proyectoGohan.Service.RespuestasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
@CrossOrigin(origins = "http://localhost:4200")
public class RespuestasController {

    @Autowired
    RespuestasService respuestasService;

    @PostMapping("/guardar-respuestas")
    public ResponseEntity<String> guardarRespuestas(@RequestBody RespuestasDto request) {
        try {
            String respuestasJson = request.getRespuestasJson();
            Persona persona = request.getPersona();

            Respuestas savedRespuestas = respuestasService.guardarRespuestas(respuestasJson, persona);

            return new ResponseEntity<>("Respuestas guardadas correctamente. ID: " + savedRespuestas.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar las respuestas: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/consultar-respuestas")
    public List<Respuestas> consultarRespuestasPorNombre(@RequestParam String nombre) {
        return respuestasService.obtenerRespuestasPorNombre(nombre);
    }
}
