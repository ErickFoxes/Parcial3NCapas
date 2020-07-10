package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.DepartamentosDAO;
import com.uca.capas.domain.Departamentos;

@Service
public class DepartamentosServiceImpl implements DepartamentosService {
	
	@Autowired
	DepartamentosDAO departamentosDAO;

	@Override
	public List<Departamentos> findAll() throws DataAccessException {
		return departamentosDAO.findAll();
	}

	@Override
	public Departamentos findOne(Integer code) throws DataAccessException {
		return departamentosDAO.findOne(code);
	}
	
	

}
