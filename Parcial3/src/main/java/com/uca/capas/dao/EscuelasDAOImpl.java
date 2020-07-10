package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import com.uca.capas.domain.Escuelas;

@Component
public class EscuelasDAOImpl implements EscuelasDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;

	@Override
	public List<Escuelas> findAll() throws DataAccessException {

		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.tb_centros_escolares");
		Query query = entityManager.createNativeQuery(sb.toString(), Escuelas.class);
		List<Escuelas> resulset = query.getResultList();
		
		return resulset;
		
	}

	@Override
	public Escuelas findOne(Integer code) throws DataAccessException {
		
		Escuelas escuela = entityManager.find(Escuelas.class, code);
		return escuela;
		
	}

	
}
