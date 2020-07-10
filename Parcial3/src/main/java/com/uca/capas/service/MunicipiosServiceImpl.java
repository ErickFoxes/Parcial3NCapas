package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.MunicipiosDAO;
import com.uca.capas.domain.Municipios;

@Service
public class MunicipiosServiceImpl implements MunicipiosService {
	
	@Autowired
	MunicipiosDAO municipiosDAO;

	@Override
	public List<Municipios> findAll() throws DataAccessException {
		return municipiosDAO.findAll();
	}

	@Override
	public Municipios findOne(Integer code) throws DataAccessException {
		return municipiosDAO.findOne(code);	
	}

}
