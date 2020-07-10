package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materias;

public interface MateriasService {
	public List<Materias> findAll() throws DataAccessException;
}
