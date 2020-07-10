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
@Table(schema="public",name="TB_MATERIA")
public class Materia {
	
	@Id
	@Column(name="id_materia")
	private Integer id_materia;
	
	@Size(message="Este campo no debe tener mas de 25 caracteres", max=25)
	@NotEmpty(message="El campo nombre de usuario no puede estar vacío")
	@Column(name="nombre_materia")
	private String nombre_materia;
	
	@OneToMany(mappedBy="materia",fetch=FetchType.EAGER)
	private List<Notas> notas;
	
	//constructor
	public Materia() {
		
	}
	
	//getters y setters
	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public String getNombre_materia() {
		return nombre_materia;
	}

	public void setNombre_materia(String nombre_materia) {
		this.nombre_materia = nombre_materia;
	}
	
}