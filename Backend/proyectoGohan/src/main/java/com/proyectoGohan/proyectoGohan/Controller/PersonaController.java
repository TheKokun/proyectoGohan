package com.proyectoGohan.proyectoGohan.Controller;

import com.proyectoGohan.proyectoGohan.Dto.Mensaje;
import com.proyectoGohan.proyectoGohan.Dto.PersonaDto;
import com.proyectoGohan.proyectoGohan.Dto.RespuestasDto;
import com.proyectoGohan.proyectoGohan.Entity.Persona;
import com.proyectoGohan.proyectoGohan.Service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Persona> getByNombre(@PathVariable("nombre") String nombre){
        if(!personaService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getByNombre(nombre).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

   /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getEmail()))
            return new ResponseEntity(new Mensaje("el email es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByNombre(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(), personaDto.getEmail(),personaDto.getEdad());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody PersonaDto personaDto){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(personaService.existsByNombre(personaDto.getNombre()) && personaService.getByNombre(personaDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByNombre(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setNombre(personaDto.getApellido());
        persona.setNombre(personaDto.getEmail());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


}