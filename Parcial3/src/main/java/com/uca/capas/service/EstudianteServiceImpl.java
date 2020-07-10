package com.uca.capas.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteDAO estudianteDAO;
	
	@Autowired
	EstudianteRepo estudianteRepo;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteRepo.findAll();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		return estudianteRepo.getOne(code);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(estudiante.getFecha_nac());
		LocalDate localFnacimiento = LocalDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()).toLocalDate();
	    Integer edad = Period.between(localFnacimiento, LocalDate.now()).getYears();
		estudiante.setEdad(edad);;	
		
		estudianteRepo.save(estudiante);
	}

	@Override
	public void updateEstudiante(Estudiante estudiante) {
		estudianteDAO.updateEstudiante(estudiante);
	}

	@Override
	public int insertEstudianteAutoId(Estudiante c) {
		return estudianteDAO.insertEstudianteAutoId(c);
	}

}
