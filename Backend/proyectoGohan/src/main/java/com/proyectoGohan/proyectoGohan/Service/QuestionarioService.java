package com.proyectoGohan.proyectoGohan.Service;

import com.proyectoGohan.proyectoGohan.Entity.Persona;
import com.proyectoGohan.proyectoGohan.Entity.Questionario;
import com.proyectoGohan.proyectoGohan.Repository.PersonaRepository;
import com.proyectoGohan.proyectoGohan.Repository.QuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionarioService
{

    @Autowired
    QuestionarioRepository questionarioRepositoryc;

    public List<Questionario> list(){
        return questionarioRepositoryc.findAll();
    }
}
