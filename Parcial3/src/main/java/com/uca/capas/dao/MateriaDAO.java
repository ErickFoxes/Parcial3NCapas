package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materias;

public interface MateriaDAO {
	public List<Materias> findAll() throws DataAccessException;
	public Materias findOne(Integer m) throws DataAccessException;
}
