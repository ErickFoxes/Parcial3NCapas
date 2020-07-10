package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materias;


public interface MateriaService {
	public List<Materias> findAllSubjects() throws DataAccessException;
	
	public Materias findSubject(Integer code) throws DataAccessException;
	
	public void saveMateria(Materias materia) throws DataAccessException;
	
	public void updateMateria(Materias materia) throws DataAccessException;

}
