package com.proyectoGohan.proyectoGohan.Service;

import com.proyectoGohan.proyectoGohan.Entity.Persona;
import com.proyectoGohan.proyectoGohan.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
    @Transactional
    public class PersonaService {

        @Autowired
        PersonaRepository personaRepository;

        public List<Persona> list(){
            return personaRepository.findAll();
        }

        public Optional<Persona> getOne(int id){
            return personaRepository.findById(id);
        }

        public Optional<Persona> getByNombre(String nombre){
            return personaRepository.findByNombre(nombre);
        }

        public void  save(Persona producto){
            personaRepository.save(producto);
        }

        public void delete(int id){
            personaRepository.deleteById(id);
        }

        public boolean existsById(int id){
            return personaRepository.existsById(id);
        }

        public boolean existsByNombre(String nombre){
            return personaRepository.existsByNombre(nombre);
        }
    }