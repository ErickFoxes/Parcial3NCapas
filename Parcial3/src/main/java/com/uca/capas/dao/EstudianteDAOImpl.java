package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materias;
import com.uca.capas.domain.Notas;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.TB_EXPEDIENTE");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);

		List<Estudiante> res = query.getResultList();
		return res;
	}

	@Override
	public Estudiante findOne(Integer m) throws DataAccessException {
		Estudiante estudiante = entityManager.find(Estudiante.class, m);
		return estudiante;
	}

}
