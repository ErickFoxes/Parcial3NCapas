package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.uca.capas.domain.Materias;


@Repository
public class MateriaDAOlmpl implements MateriaDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	JdbcTemplate jdbcTemplate;
	
	public static final String sql = "UPDATE store.TB_MATERIA SET nombre = ? WEHRE id_materia = ?";

	@Override
	public List<Materias> findAllSubjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materias findSubject(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMateria(Materias materia) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(materia.getId_materia() == null) {
				entityManager.persist(materia);
			}
			else {
				entityManager.merge(materia);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUsuario(Materias materia) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}



}
