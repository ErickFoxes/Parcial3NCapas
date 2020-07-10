package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EscuelasDAO;
import com.uca.capas.domain.Escuelas;

@Service
public class EscuelasServiceImpl implements EscuelasService {
	
	@Autowired
	EscuelasDAO escuelasDAO;

	@Override
	public List<Escuelas> findAll() throws DataAccessException {
		return escuelasDAO.findAll();
	}

	@Override
	public Escuelas findOne(Integer code) throws DataAccessException {
		return escuelasDAO.findOne(code);
	}

}
