package com.uca.capas.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.uca.capas.domain.Escuelas;

public class CentroEscolarDAOlmpl implements CentroEscolarDAO {
	
	@Autowired	
	JdbcTemplate jdbcTemplate;
	
	public static final String sql = "UPDATE store.TB_CENTROS ESCOLARES SET nombre_centro_escolar = ?, id_departamento = ?, id_municipio = ? WEHRE id_centro_escolar = ?";

	@Override
	public int saveEscuela(Escuelas escuela) {
		// TODO Auto-generated method stub
		SimpleJdbcInsert jdbcInsert1 = new SimpleJdbcInsert(jdbcTemplate).withSchemaName("TB_DEPARTAMENTO").withTableName("TB_CENTROS_ESCOLARES").usingGeneratedKeyColumns("id_departamento");
		SimpleJdbcInsert jdbcInsert2 = new SimpleJdbcInsert(jdbcTemplate).withSchemaName("TB_MUNICIPIOS").withTableName("TB_CENTROS_ESCOLARES").usingGeneratedKeyColumns("id_municipio");
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre_centro_escolar", escuela.getNombre_centro_escolar());
		
		Number id_genered1 = jdbcInsert1.executeAndReturnKey(parametros);
		Number id_genered2 = jdbcInsert2.executeAndReturnKey(parametros);
		
		return id_genered1 , id_genered2;
	}

	@Override
	public void updateEscuela(Escuelas escuela) {
		// TODO Auto-generated method stub
		Object[] parametros = new Object [] {escuela.getNombre_centro_escolar(), escuela.getId_departamento(), escuela.getId_municipio(), escuela.getId_escuela()};
		jdbcTemplate.update(sql,parametros);
	}

}
