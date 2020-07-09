package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materias;

public interface EstudianteDAO {
	public List<Estudiante> findAll() throws DataAccessException;
	public Estudiante findOne(Integer m) throws DataAccessException;
}
