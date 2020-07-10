package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import javax.persistence.Query;


import com.uca.capas.domain.Usuario;

@Component
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Usuario> findAll() throws DataAccessException {
		StringBuffer sb= new StringBuffer();
		sb.append("select * from public.tb_usuario");
		Query query =entityManager.createNativeQuery(sb.toString(),Usuario.class);
		List<Usuario> resulset=query.getResultList();
		
		return resulset;
	}

	@Override
	public void save(Usuario user) throws DataAccessException {
		
			if(user.getId_usuario() == null){
				entityManager.persist(user);
			} else {
				entityManager.merge(user);
				entityManager.flush();
			}
		
		
	}

}
