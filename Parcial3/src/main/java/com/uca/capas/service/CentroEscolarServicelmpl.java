package com.uca.capas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CentroEscolarDAO;
import com.uca.capas.domain.Escuelas;

@Service
public class CentroEscolarServicelmpl implements CentroEscolarService{
	
	@Autowired
	CentroEscolarDAO centroEscolarDAO;

	@Override
	public int saveEscuela(Escuelas escuela) {
		// TODO Auto-generated method stub
		return centroEscolarDAO.saveEscuela(escuela);
	}

	@Override
	public void updateEscuela(Escuelas escuela) {
		// TODO Auto-generated method stub
		centroEscolarDAO.updateEscuela(escuela);
	}
	
	
}
