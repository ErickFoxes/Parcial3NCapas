package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Escuelas;

public interface EscuelasDAO {

	public List<Escuelas> findAll() throws DataAccessException;
	
	public Escuelas findOne(Integer code) throws DataAccessException;
	
}
