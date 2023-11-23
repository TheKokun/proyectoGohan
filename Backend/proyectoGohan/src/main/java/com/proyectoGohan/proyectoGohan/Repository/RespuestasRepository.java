package com.proyectoGohan.proyectoGohan.Repository;

import com.proyectoGohan.proyectoGohan.Entity.Persona;
import com.proyectoGohan.proyectoGohan.Entity.Respuestas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RespuestasRepository extends JpaRepository<Respuestas, Integer> {
    List<Respuestas> findByPersonaNombreContaining(String nombre);
}
