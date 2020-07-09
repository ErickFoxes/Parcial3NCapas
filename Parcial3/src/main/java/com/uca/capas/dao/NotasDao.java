package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Notas;

public interface NotasDao {
	
	public List<Notas> findAll() throws DataAccessException;
	
	public void save(Notas n) throws DataAccessException;
}
