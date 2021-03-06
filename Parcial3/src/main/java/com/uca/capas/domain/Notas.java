package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema="public",name="TB_ESTUDIANTE_NOTA")
public class Notas {

	@Id
	@Column(name="id_estudiante")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_estudiante;
	
	@NotEmpty(message="El campo nombre de usuario no puede estar vacío")
	@Column(name="ciclo")
	private Integer ciclo;
	
	@NotEmpty(message="El campo nombre de usuario no puede estar vacío")
	@Column(name="anno")
	private Integer anno;
	
	@NotEmpty(message="El campo nombre de usuario no puede estar vacío")
	@Column(name="nota")
	private Double nota;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_materia")
	private Materias materia;
	
	@Transient
	private Integer id_materia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_expediente")
	private Estudiante expediente;
	
	@Transient
	private Integer id_expediente;

	public Integer getId_materia2() {
		return this.materia.getId_materia();
	}
	
	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public Integer getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(Integer id_expediente) {
		this.id_expediente = id_expediente;
	}

	public Materias getMateria() {
		return materia;
	}

	public void setMateria(Materias materia) {
		this.materia = materia;
	}

	public Estudiante getExpediente() {
		return expediente;
	}

	public void setExpediente(Estudiante expediente) {
		this.expediente = expediente;
	}

	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	//Dunciones delegate
		public String getNotaDelegate() {
			if(this.nota == null) return "";
			else {
				return nota >= 6 ?"Aprobado":"Reprobado";
			}
		}
	
}
