package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Notas;

public interface NotasService {
	public List<Notas> findAll() throws DataAccessException;
	public void save(Notas notas) throws DataAccessException;
	public Notas findOne(Integer code) throws DataAccessException;
}
