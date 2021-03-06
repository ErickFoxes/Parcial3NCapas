package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Escuela;


public interface CentroEscolarDAO {
	
	public List<Escuela> findAllSchools() throws DataAccessException;
	
	public Escuela findOneSchool(Integer code) throws DataAccessException;
	
	public void saveEscuela(Escuela escuela) throws DataAccessException;
	
	public void updateEscuela(Escuela escuela) throws DataAccessException;
	
}
