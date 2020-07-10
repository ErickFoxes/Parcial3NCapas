package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.MateriaDAO;
import com.uca.capas.domain.Materia;
import com.uca.capas.repositories.MateriaRepo;

@Service
public class MateriaServicelmpl implements MateriaService{
	
	@Autowired
	MateriaDAO materiaDAO; 
	
	@Autowired
	MateriaRepo materiaRepo;

	@Override
	public List<Materia> findAllSubjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return materiaRepo.findAll(); 
	}

	@Override
	public Materia findSubject(Integer code) throws DataAccessException { 
		// TODO Auto-generated method stub 
		return materiaRepo.getOne(code); 
	}

	@Override
	@Transactional
	public void saveMateria(Materia materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaRepo.save(materia);
	}

	@Override
	@Transactional
	public void updateMateria(Materia materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaDAO.updateMateria(materia);
	}
	
	

}
