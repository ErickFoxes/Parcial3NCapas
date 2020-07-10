package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Usuario;


public interface MateriaDAO {
	
	public List<Materia> findAllSubjects() throws DataAccessException;
	
	public Materia findSubject(Integer code) throws DataAccessException;
	
	public void saveMateria(Materia materia) throws DataAccessException;
	
	public void updateMateria(Materia materia) throws DataAccessException;

}
