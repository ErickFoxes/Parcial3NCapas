package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="TB_CENTROS_ESCOLARES")
public class Escuelas {

	@Id
	@Column(name="id_centro_escolar")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_escuela;
	
	@Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="El campo primer nombre no puede estar vacío")
	@Column(name="nombre_centro_escolar")
	private String nombre_centro_escolar;
	
	@NotEmpty(message="El campo municipio no puede estar vacío")
	@Column(name="id_municipio")
	private int id_municipio;
	
	//@NotEmpty(message="El campo departamento no puede estar vacío")
	@Column(name="id_departamento")
	private int id_departamento;
	
	public Escuelas() {
		super();
	}

	public int getId_escuela() {
		return id_escuela;
	}

	public void setId_escuela(int id_escuela) {
		this.id_escuela = id_escuela;
	}

	public String getNombre_centro_escolar() {
		return nombre_centro_escolar;
	}

	public void setNombre_centro_escolar(String nombre_centro_escolar) {
		this.nombre_centro_escolar = nombre_centro_escolar;
	}

	public int getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
	
	
}