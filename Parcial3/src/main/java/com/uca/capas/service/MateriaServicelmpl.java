package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.MateriaDAO;
import com.uca.capas.domain.Materias;

@Service
public class MateriaServicelmpl implements MateriaService{
	
	@Autowired
	MateriaDAO materiaDAO;

	@Override
	public List<Materias> findAllSubjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return materiaDAO.findAllSubjects();
	}

	@Override
	public Materias findSubject(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return materiaDAO.findSubject(code);
	}

	@Override
	@Transactional
	public void saveMateria(Materias materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaDAO.saveMateria(materia);
	}

	@Override
	@Transactional
	public void updateMateria(Materias materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaDAO.updateUsuario(materia);
	}
	
	

}
