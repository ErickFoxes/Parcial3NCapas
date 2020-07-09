package com.uca.capas.dao;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materias;


public interface MateriaDAO {
	
	public void save(Materias materia) throws DataAccessException;
	
	
	

}
