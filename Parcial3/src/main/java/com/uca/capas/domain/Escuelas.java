package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="TB_CENTROS_ESCOLARES")
public class Escuelas {

	/*
	@OneToMany(mappedBy="id_centro_escolar",fetch=FetchType.EAGER)
	private List<Estudiante> estudiantes;
	*/
	
	@Id
	@Column(name="id_centro_escolar")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_centro_escolar;
	
	@Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="El campo primer nombre no puede estar vacío")
	@Column(name="nombre_centro_escolar")
	private String nombre_centro_escolar;
	
	@NotEmpty(message="El campo municipio no puede estar vacío")
	@JoinColumn(name="id_municipio")
	@ManyToOne(fetch=FetchType.LAZY)
	private Municipios id_municipio;
	
	@NotEmpty(message="El campo departamento no puede estar vacío")
	@JoinColumn(name="id_departamento")
	@ManyToOne(fetch=FetchType.LAZY)
	private Departamentos id_departamento;
	
	public Escuelas() {
		super();
	}

	public Integer getId_centro_escolar() {
		return id_centro_escolar;
	}

	public void setId_centro_escolar(Integer id_centro_escolar) {
		this.id_centro_escolar = id_centro_escolar;
	}



	public String getNombre_centro_escolar() {
		return nombre_centro_escolar;
	}

	public void setNombre_centro_escolar(String nombre_centro_escolar) {
		this.nombre_centro_escolar = nombre_centro_escolar;
	}

	public Municipios getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Municipios id_municipio) {
		this.id_municipio = id_municipio;
	}

	public Departamentos getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Departamentos id_departamento) {
		this.id_departamento = id_departamento;
	}
	
	
}