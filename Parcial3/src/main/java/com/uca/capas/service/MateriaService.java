package com.uca.capas.service;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materias;


public interface MateriaService {
	public void save(Materias materia) throws DataAccessException;
	
}
