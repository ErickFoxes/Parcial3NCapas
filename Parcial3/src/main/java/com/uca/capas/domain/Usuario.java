package com.uca.capas.domain;


import java.util.Date;

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
@Table(schema="public", name="TB_USUARIO")
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_usuario;
	
	@Size(message="Este campo no debe tener mas de 1 caracter", max=1)
	@NotEmpty(message="El campo rol no puede estar vacío")
	@Column(name="rol")
	private int rol;
	
	@Size(message="Este campo no debe tener mas de 20 caracteres", max=20)
	@NotEmpty(message="El campo nombre de usuario no puede estar vacío")
	@Column(name="nombre_usuario")
	private String nombre_usuario;
	
	@Size(message="Este campo no debe tener mas de 25 caracteres", max=25)
	@NotEmpty(message="El campo contraseña no puede estar vacío")
	@Column(name="contrasenna")
	private String contrasenna;
	
	@Size(message="Este campo no debe tener mas de 20 caracteres", max=20)
	@NotEmpty(message="El campo nombre no puede estar vacío")
	@Column(name="nombre")
	private String nombre;
	
	@Size(message="Este campo no debe tener mas de 20 caracteres", max=20)
	@NotEmpty(message="El campo apellido no puede estar vacío")
	@Column(name="apellido")
	private String apellido;
	
	@Size(message="Este campo debe estar entre 7 y 18", min=7 , max=18)
	@NotEmpty(message="El campo edad no puede estar vacío")
	@Column(name="edad")
	private int edad;
	
	@NotEmpty(message="El campo fecha de nacimiento no puede estar vacío")
	@Column(name="fecha_nac")
	private Date fecha_nac;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotEmpty(message="El campo departamento no puede estar vacío")
	@JoinColumn(name="id_departamento")
	private Departamentos id_departamento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotEmpty(message="El campo municipio no puede estar vacío")
	@JoinColumn(name="id_municipio")
	private Municipios id_municipio;
	
	@Size(message="Este campo no debe tener mas de 20 caracteres", max=20)
	@NotEmpty(message="El campo direccion de residencia no puede estar vacío")
	@Column(name="direccion_residencia")
	private String direccion_residencia;
	
	@Column(name="estado")
	private Boolean estado;
	
	//FUNCION
	public String getEstadoDelegate() {
		if(this.estado==null)return "";
		else {
			return estado == true? "Activo":"Inactivo";
		}
	}
	
	
	//GETTERS Y SETTERS

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public Departamentos getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Departamentos id_departamento) {
		this.id_departamento = id_departamento;
	}

	public Municipios getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Municipios id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getDireccion_residencia() {
		return direccion_residencia;
	}

	public void setDireccion_residencia(String direccion_residencia) {
		this.direccion_residencia = direccion_residencia;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
