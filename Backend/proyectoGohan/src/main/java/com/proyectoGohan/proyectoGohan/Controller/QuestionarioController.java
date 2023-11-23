package com.proyectoGohan.proyectoGohan.Controller;

import com.proyectoGohan.proyectoGohan.Entity.Persona;
import com.proyectoGohan.proyectoGohan.Entity.Questionario;
import com.proyectoGohan.proyectoGohan.Service.PersonaService;
import com.proyectoGohan.proyectoGohan.Service.QuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/questionario")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionarioController {

    @Autowired
    QuestionarioService questionarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Questionario>> list(){
        List<Questionario> list = questionarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
