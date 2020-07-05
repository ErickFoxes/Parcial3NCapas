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
@Table(schema="public",name="TB_MUNICIPIOS")
public class Municipios {
	
	@OneToMany(mappedBy="id_municipio",fetch=FetchType.EAGER)
	private List<Estudiante> estudiantes;
	
	@OneToMany(mappedBy="id_municipio")
	private List<Escuelas> escuelas;
	
	@OneToMany(mappedBy="id_municipio")
	private List<Usuario> usuarios;
	
	@Id
	@Column(name="id_municipio")
	private int id_municipio;
	
	@Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="El campo primer nombre no puede estar vacío")
	@Column(name="nombre_municipio")
	private String nombre_municipio;
	
	@NotEmpty(message="El campo departamento no puede estar vacío")
	@JoinColumn(name="id_departamento")
	@ManyToOne(fetch=FetchType.LAZY)
	private Departamentos id_departamento;
	

	public Municipios() {
		super();
	}

	public int getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getNombre_municipio() {
		return nombre_municipio;
	}

	public void setNombre_municipio(String nombre_municipio) {
		this.nombre_municipio = nombre_municipio;
	}

	public Departamentos getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Departamentos id_departamento) {
		this.id_departamento = id_departamento;
	}
	
	
}
