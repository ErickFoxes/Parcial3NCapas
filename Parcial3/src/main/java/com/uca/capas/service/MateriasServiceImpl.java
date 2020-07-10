package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.MateriaDAO;
import com.uca.capas.domain.Materias;

@Service
public class MateriasServiceImpl implements MateriasService{

	@Autowired
	MateriaDAO materiasDao;
	
	@Override
	public List<Materias> findAll() throws DataAccessException {
		return materiasDao.findAll();
	}

}
