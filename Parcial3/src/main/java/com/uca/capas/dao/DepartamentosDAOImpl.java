package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.uca.capas.domain.Departamentos;

@Component
public class DepartamentosDAOImpl implements DepartamentosDAO {
	
	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;

	@Override
	public List<Departamentos> findAll() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.tb_departamento");
		Query query = entityManager.createNativeQuery(sb.toString(), Departamentos.class);
		List<Departamentos> resulset = query.getResultList();
		
		return resulset;
		
	}

	@Override
	public Departamentos findOne(Integer code) throws DataAccessException {
		
		Departamentos departamento = entityManager.find(Departamentos.class, code);
		return departamento;
		
	}


}
