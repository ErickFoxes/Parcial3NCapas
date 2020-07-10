package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.CentroEscolarDAO;
import com.uca.capas.domain.Escuela;
import com.uca.capas.repositories.EscuelaRepo;
import com.uca.capas.repositories.UsuarioRepo;

@Service
public class CentroEscolarServicelmpl implements CentroEscolarService{
	
	@Autowired
	CentroEscolarDAO centroEscolarDAO;
	
	@Autowired
	EscuelaRepo escuelaRepo;

	@Override
	public List<Escuela> findAllSchools() throws DataAccessException {
		// TODO Auto-generated method stub
		return escuelaRepo.findAll();
	}

	@Override
	public Escuela findOneSchool(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return escuelaRepo.getOne(code);
	}

	@Override
	@Transactional
	public void saveEscuela(Escuela escuela) throws DataAccessException {
		// TODO Auto-generated method stub
		escuelaRepo.save(escuela);
	}

	@Override
	@Transactional
	public void updateEscuela(Escuela escuela) throws DataAccessException {
		// TODO Auto-generated method stub
		centroEscolarDAO.updateEscuela(escuela);
	}
	
}
