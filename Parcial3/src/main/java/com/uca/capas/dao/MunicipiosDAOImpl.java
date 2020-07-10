package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.uca.capas.domain.Municipios;

@Component
public class MunicipiosDAOImpl implements MunicipiosDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;

	@Override
	public List<Municipios> findAll() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.tb_municipios");
		Query query = entityManager.createNativeQuery(sb.toString(), Municipios.class);
		List<Municipios> resulset = query.getResultList();
		
		return resulset;
		
	}

	@Override
	public Municipios findOne(Integer code) throws DataAccessException {
		
		Municipios municipio = entityManager.find(Municipios.class, code);
		return municipio;
		
	}
	
	

}
