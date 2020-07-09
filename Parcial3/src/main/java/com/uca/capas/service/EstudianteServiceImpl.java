package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.dao.NotasDao;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteRepo estudianteRepo;
	
	@Autowired
	EstudianteDAO estudianteDao;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteDao.findAll();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		return estudianteRepo.getOne(code);
	}


}
