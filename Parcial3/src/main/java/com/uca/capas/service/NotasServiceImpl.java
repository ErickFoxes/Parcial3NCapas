package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.dao.MateriaDAO;
import com.uca.capas.dao.NotasDao;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materias;
import com.uca.capas.domain.Notas;
import com.uca.capas.repositories.NotasRepo;

@Service
public class NotasServiceImpl implements NotasService{
	
	@Autowired
	NotasDao notasDao;

	@Autowired
	NotasRepo notasRepo;
	
	@Autowired
	MateriaDAO materiaDao;
	
	@Autowired
	EstudianteDAO estudianteDao;
	
	
	@Override
	public List<Notas> findAll() throws DataAccessException {
		return notasDao.findAll();
	}

	@Override
	public void save(Notas notas) throws DataAccessException {
		notas.setMateria(materiaDao.findOne(notas.getId_materia()));
		notas.setExpediente(estudianteDao.findOne(notas.getId_expediente()));
		notasRepo.save(notas);
		
	}

	@Override
	public Notas findOne(Integer code) throws DataAccessException {
		return notasRepo.getOne(code);
	}

	@Override
	public List<Notas> filtrarPorId(Estudiante estudiante) throws DataAccessException {
		return notasRepo.findByExpediente(estudiante);
	}

	@Override
	public List<Notas> filtrarPorReprobados(int estudiante) throws DataAccessException {
		return notasRepo.findByNotaLessThan(estudiante);
	}

	@Override
	public List<Notas> filtrarPorAprobados(int estudiante) throws DataAccessException {
		return notasRepo.findByNotaGreaterThanEqual(estudiante);
	}



}
