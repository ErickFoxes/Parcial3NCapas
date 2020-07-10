package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Escuela;
import com.uca.capas.domain.Materia;


@Repository
public class MateriaDAOlmpl implements MateriaDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	public static final String sql = "UPDATE public.TB_MATERIA SET nombre_materia = ? WEHRE id_materia = ?";

	@Override
	public List<Materia> findAllSubjects() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from  public.TB_MATERIA");
		
		Query query = entityManager.createNativeQuery(sb.toString(),Escuela.class);
		List<Materia> result = query.getResultList();
		return result;
	}

	@Override
	public Materia findSubject(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Materia materia = entityManager.find(Materia.class, code);
		return materia;
	}

	@Override
	@Transactional 
	public void saveMateria(Materia materia) throws DataAccessException {
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
	public void updateMateria(Materia materia) throws DataAccessException {
		// TODO Auto-generated method stub
		Object[] parametros = new Object [] {materia.getId_materia(), materia.getNombre_materia()};
		jdbcTemplate.update(sql,parametros);
	}



}
