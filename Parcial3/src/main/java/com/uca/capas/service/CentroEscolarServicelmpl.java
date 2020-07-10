package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.CentroEscolarDAO;
import com.uca.capas.domain.Escuelas;

@Service
public class CentroEscolarServicelmpl implements CentroEscolarService{
	
	@Autowired
	CentroEscolarDAO centroEscolarDAO;

	@Override
	public List<Escuelas> findAllSchools() throws DataAccessException {
		// TODO Auto-generated method stub
		return centroEscolarDAO.findAllSchools();
	}

	@Override
	public Escuelas findOneSchool(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return centroEscolarDAO.findOneSchool(code);
	}

	@Override
	@Transactional
	public void saveEscuela(Escuelas escuela) throws DataAccessException {
		// TODO Auto-generated method stub
		centroEscolarDAO.saveEscuela(escuela);
	}

	@Override
	@Transactional
	public void updateEscuela(Escuelas escuela) throws DataAccessException {
		// TODO Auto-generated method stub
		centroEscolarDAO.updateEscuela(escuela);
	}
	
}
