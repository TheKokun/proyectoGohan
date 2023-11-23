package com.proyectoGohan.proyectoGohan.Entity;

import jakarta.persistence.*;

@Entity
public class Respuestas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String respuestasJson;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    public Respuestas() {
    }

    public Respuestas(String respuestasJson,Persona persona) {
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
