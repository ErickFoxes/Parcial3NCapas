package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materias;
import com.uca.capas.domain.Notas;

public interface NotasRepo extends JpaRepository<Notas, Integer>{
	public List<Notas> findByExpediente(Estudiante estudiante) throws DataAccessException;
	@Query("select c from Notas c where c.nota < 6 and c.expediente.id_estudiante = ?1")
	public List<Notas> findByNotaLessThan(int estudiante) throws DataAccessException;
	@Query("select c from Notas c where c.nota >= 6 and c.expediente.id_estudiante = ?1")
	public List<Notas> findByNotaGreaterThanEqual(int estudiante) throws DataAccessException;
}
