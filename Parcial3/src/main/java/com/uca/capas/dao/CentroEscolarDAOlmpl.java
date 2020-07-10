package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Escuela;

@Repository
public class CentroEscolarDAOlmpl implements CentroEscolarDAO {
	
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	JdbcTemplate jdbcTemplate;
	
	public static final String sql = "UPDATE public.TB_CENTROS ESCOLARES SET nombre_centro_escolar = ?, id_departamento = ?, id_municipio = ? WEHRE id_centro_escolar = ?";

	@Override
	public List<Escuela> findAllSchools() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.TB_CENTROS_ESCOLARES");
		
		Query query = entityManager.createNativeQuery(sb.toString(),Escuela.class);
		List<Escuela>result=query.getResultList();
		return result;
	}

	@Override
	public Escuela findOneSchool(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Escuela escuela = entityManager.find(Escuela.class, code);
		return escuela;
	}

	@Override
	public void saveEscuela(Escuela escuela) throws DataAccessException {
		try {
			if(escuela.getId_escuela()== null) {
				entityManager.persist(escuela);
			}
			else {
				entityManager.merge(escuela);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEscuela(Escuela escuela) throws DataAccessException {
		// TODO Auto-generated method stub
		Object[] parametros = new Object [] {escuela.getNombre_centro_escolar(), escuela.getId_departamento(), escuela.getId_municipio(), escuela.getId_escuela()};
		jdbcTemplate.update(sql,parametros);
		
	}



}
