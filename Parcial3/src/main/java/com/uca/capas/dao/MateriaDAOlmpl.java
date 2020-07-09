package com.uca.capas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


import com.uca.capas.domain.Materias;


@Repository
public class MateriaDAOlmpl implements MateriaDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public void save(Materias materia) throws DataAccessException {
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

}
