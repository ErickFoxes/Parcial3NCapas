package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="TB_DEPARTAMENTOS")
public class Departamentos {
	
	/*
	@OneToMany(mappedBy="id_departamento",fetch=FetchType.EAGER)
	private List<Estudiante> estudiantes;
	*/
	
	@OneToMany(mappedBy="id_departamento")
	private List<Municipios> municipios;
	
	@OneToMany(mappedBy="id_departamento")
	private List<Escuelas> escuelas;
	
	@OneToMany(mappedBy="id_departamento")
	private List<Usuario> usuarios;
	
	@Id
	@Column(name="id_departamento")
	private Integer id_departamento;
	
	@Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="El campo primer nombre no puede estar vacío")
	@Column(name="nombre_departamento")
	private String nombre_departamento;

	public Departamentos() {
		super();
	}

	public Integer getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Integer id_departamento) {
		this.id_departamento = id_departamento;
	}



	public String getNombre_departamento() {
		return nombre_departamento;
	}

	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}
	
}