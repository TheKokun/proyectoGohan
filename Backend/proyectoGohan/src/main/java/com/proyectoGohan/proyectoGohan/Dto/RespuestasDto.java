package com.proyectoGohan.proyectoGohan.Dto;

import com.proyectoGohan.proyectoGohan.Entity.Persona;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class RespuestasDto {

    private int id;
    private String respuestasJson;

    private Persona persona;


    public RespuestasDto() {
    }

    public RespuestasDto(String respuestasJson,Persona persona) {
        this.respuestasJson = respuestasJson;
        this.persona=persona;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRespuestasJson() {
        return respuestasJson;
    }

    public void setRespuestasJson(String respuestasJson) {
        this.respuestasJson = respuestasJson;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
