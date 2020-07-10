package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Materias;

@Repository
public class MateriasDAOImpl implements MateriasDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Materias> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.TB_MATERIA");
		Query query = entityManager.createNativeQuery(sb.toString(), Materias.class);

		List<Materias> res = query.getResultList();
		return res;
	}

	@Override
	public Materias findOne(Integer m) throws DataAccessException {
		Materias materia = entityManager.find(Materias.class, m);
		return materia;
	}

}
