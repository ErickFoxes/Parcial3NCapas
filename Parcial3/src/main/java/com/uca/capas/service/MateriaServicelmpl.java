package com.uca.capas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.MateriaDAO;
import com.uca.capas.domain.Materias;

@Service
public class MateriaServicelmpl implements MateriaService{
	
	@Autowired
	MateriaDAO materiaDAO;
	
	@Override
	public void save(Materias materia) throws DataAccessException {
		// TODO Auto-generated method stub
		materiaDAO.save(materia);
	}

}
