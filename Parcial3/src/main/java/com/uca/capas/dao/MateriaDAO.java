package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materias;
import com.uca.capas.domain.Usuario;


public interface MateriaDAO {
	
	public List<Materias> findAllSubjects() throws DataAccessException;
	
	public Materias findSubject(Integer code) throws DataAccessException;
	
	public void saveMateria(Materias materia) throws DataAccessException;
	
	public void updateUsuario(Materias materia) throws DataAccessException;

}
