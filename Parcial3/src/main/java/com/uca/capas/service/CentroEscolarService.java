package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Escuelas;

public interface CentroEscolarService {
	public List<Escuelas> findAllSchools() throws DataAccessException;
	
	public Escuelas findOneSchool(Integer code) throws DataAccessException;
	
	public void saveEscuela(Escuelas escuela) throws DataAccessException;
	
	public void updateEscuela(Escuelas escuela) throws DataAccessException;
	
}
