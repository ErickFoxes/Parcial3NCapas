package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="TB_EXPEDIENTE")
public class Estudiante {
	private int id_estudiante;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String carnet;
	private Date fecha_nac;
	private String direccion_vivienda;
	private String tel;
	private String cel;
	private int id_centro_escolar;
	private String nombre_padre;
	private String nombre_madre;
	private int id_municipio;
	private int id_departamento;
}
