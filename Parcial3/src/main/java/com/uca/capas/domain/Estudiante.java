package com.uca.capas.domain;

import java.util.Date;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.uca.capas.service.NotasService;

@Entity
@Table(schema="public",name="TB_EXPEDIENTE")
public class Estudiante {

	@Id
	@Column(name="id_expediente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_estudiante;
	
	@Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="El campo primer nombre no puede estar vacío")
	@Column(name="nombre1")
	private String nombre1;
	
	@Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="El campo segundo nombre no puede estar vacío")
	@Column(name="nombre2")
	private String nombre2;
	
	@Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="El campo primer apellido no puede estar vacío")
	@Column(name="apellido1")
	private String apellido1;
	
	@Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="El campo segundo apellido no puede estar vacío")
	@Column(name="apellido2")
	private String apellido2;
	
	@Size(message="Este campo no debe tener mas de 9 caracteres", max=9)
	@NotEmpty(message="El campo carnet no puede estar vacío")
	@Column(name="carnet")
	private String carnet;
	
	@NotEmpty(message="El campo fecha de nacimiento no puede estar vacío")
	@Column(name="fecha_nac")
	private Date fecha_nac;
	
	@Size(message="Este campo no debe tener mas de 100 caracteres", max=100)
	@NotEmpty(message="El campo dirección de vivienda no puede estar vacío")
	@Column(name="direccion_vivienda")
	private String direccion_vivienda;
	
	@Size(message="Este campo no debe tener mas de 8 caracteres", max=8)
	@NotEmpty(message="El campo telefono no puede estar vacío")
	@Column(name="telefono")
	private String tel;
	
	@Size(message="Este campo no debe tener mas de 8 caracteres", max=8)
	@NotEmpty(message="El campo celular no puede estar vacío")
	@Column(name="celular")
	private String cel;
	
	//Tomany
	@ManyToOne(fetch=FetchType.LAZY)
	@NotEmpty(message="El campo centro escolar de procedencia no puede estar vacío")
	@JoinColumn(name="id_centro_escolar")
	private Escuelas id_centro_escolar;
	
	@Size(message="Este campo no debe tener mas de 50 caracteres", max=50)
	@NotEmpty(message="El campo nombres del padre no puede estar vacío")
	@Column(name="nombre_padre")
	private String nombre_padre;
	
	@Size(message="Este campo no debe tener mas de 50 caracteres", max=50)
	@NotEmpty(message="El campo nombres de las madre no puede estar vacío")
	@Column(name="nombre_madre")
	private String nombre_madre;
	
	//Tomany
	@ManyToOne(fetch=FetchType.LAZY)
	@NotEmpty(message="El campo municipio no puede estar vacío")
	@JoinColumn(name="id_municipio")
	private Municipios id_municipio;
	
	//Tomany
	@ManyToOne(fetch=FetchType.LAZY)
	@NotEmpty(message="El campo departamento no puede estar vacío")
	@JoinColumn(name="id_departamento")
	private Departamentos id_departamento;
	
	@OneToMany(mappedBy="expediente",fetch=FetchType.EAGER)
	private List<Notas> notas;
	
	@Transient
	private Integer reprobados;
	
	@Transient
	private Integer aprobados;
	
	@Transient
	private Double promedio; 
	
	
	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public Integer getAprobados() {
		return aprobados;
	}

	public void setAprobados(Integer aprobados) {
		this.aprobados = aprobados;
	}

	public Integer getReprobados() {
		return reprobados;
	}

	public void setReprobados(Integer reprobados) {
		this.reprobados = reprobados;
	}

	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}

	public Estudiante() {}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getDireccion_vivienda() {
		return direccion_vivienda;
	}

	public void setDireccion_vivienda(String direccion_vivienda) {
		this.direccion_vivienda = direccion_vivienda;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public Escuelas getId_centro_escolar() {
		return id_centro_escolar;
	}

	public void setId_centro_escolar(Escuelas id_centro_escolar) {
		this.id_centro_escolar = id_centro_escolar;
	}

	public String getNombre_padre() {
		return nombre_padre;
	}

	public void setNombre_padre(String nombre_padre) {
		this.nombre_padre = nombre_padre;
	}

	public String getNombre_madre() {
		return nombre_madre;
	}

	public void setNombre_madre(String nombre_madre) {
		this.nombre_madre = nombre_madre;
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
