package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
	public List<Estudiante> findByNombre1(String nombre) throws DataAccessException;
	public List<Estudiante> findByApellido1(String nombre) throws DataAccessException;
}
