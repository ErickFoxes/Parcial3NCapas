package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteService {

	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	
	public void updateEstudiante(Estudiante estudiante);
	
	public int insertEstudianteAutoId(Estudiante c);
	
	public List<Estudiante> filtrarPorNombre(String nombre) throws DataAccessException;
	
	public List<Estudiante> filtrarPorApellido(String nombre) throws DataAccessException;
}
