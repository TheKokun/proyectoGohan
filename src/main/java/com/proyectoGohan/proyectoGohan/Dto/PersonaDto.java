package com.proyectoGohan.proyectoGohan.Dto;

import jakarta.validation.constraints.NotBlank;

public class PersonaDto {
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String email;
	@NotBlank
	private String edad;


	public PersonaDto(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String email,
			@NotBlank String edad) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEdad() {
		return edad;
	}


	public void setedad(String edad) {
		this.edad = edad;
	}
	
}