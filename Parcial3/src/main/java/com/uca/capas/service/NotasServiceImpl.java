package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.NotasDao;
import com.uca.capas.domain.Notas;
import com.uca.capas.repositories.NotasRepo;

@Service
public class NotasServiceImpl implements NotasService{
	
	@Autowired
	NotasDao notasDao;

	@Autowired
	NotasRepo notasRepo;
	
	@Override
	public List<Notas> findAll() throws DataAccessException {
		return notasDao.findAll();
	}

	@Override
	public void save(Notas notas) throws DataAccessException {
		notasDao.save(notas);
		
	}

	@Override
	public Notas findOne(Integer code) throws DataAccessException {
		return notasRepo.getOne(code);
	}

}
