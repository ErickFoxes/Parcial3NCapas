package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="TB_ROL")
public class Rol {
	@Id
	@Column(name="id_rol")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int rol_id;
	
	@Column(name="id_rol")
	String rol;
	
	@OneToMany(mappedBy="id_rol",fetch=FetchType.EAGER)
	private List<Usuario> usuarios;
}
