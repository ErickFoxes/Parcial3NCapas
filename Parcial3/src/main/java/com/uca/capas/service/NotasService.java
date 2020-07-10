package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materias;
import com.uca.capas.domain.Notas;

public interface NotasService {
	public List<Notas> findAll() throws DataAccessException;
	public void save(Notas notas) throws DataAccessException;
	public Notas findOne(Integer code) throws DataAccessException;
	public List<Notas> filtrarPorId(Estudiante estudiante) throws DataAccessException;
	public List<Notas> filtrarPorReprobados(int estudiante) throws DataAccessException;
	public List<Notas> filtrarPorAprobados(int estudiante) throws DataAccessException;
}
