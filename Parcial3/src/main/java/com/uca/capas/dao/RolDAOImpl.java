package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.uca.capas.domain.Rol;
@Component
public class RolDAOImpl implements RolDao {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Rol> findAll() throws DataAccessException {
		StringBuffer sb= new StringBuffer();
		sb.append("select * from public.tb_rol");
		Query query =entityManager.createNativeQuery(sb.toString(),Rol.class);
		List<Rol> resulset=query.getResultList();
		
		return resulset;
	}

	@Override
	public Rol findOne(Integer rol_id) throws DataAccessException {
		Rol rol = entityManager.find(Rol.class, rol_id);
		return rol;
	}

}
