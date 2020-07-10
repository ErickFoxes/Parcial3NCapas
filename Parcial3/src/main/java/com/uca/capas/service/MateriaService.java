package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materia;


public interface MateriaService {
	public List<Materia> findAllSubjects() throws DataAccessException;
	
	public Materia findSubject(Integer code) throws DataAccessException;
	
	public void saveMateria(Materia materia) throws DataAccessException;
	
	public void updateMateria(Materia materia) throws DataAccessException;

}
