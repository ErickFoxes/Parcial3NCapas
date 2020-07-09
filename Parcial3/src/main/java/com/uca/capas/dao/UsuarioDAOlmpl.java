package com.uca.capas.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.uca.capas.domain.Usuario;

public class UsuarioDAOlmpl implements UsuarioDAO {
	
	@Autowired	
	JdbcTemplate jdbcTemplate;
	
	public static final String sql = "UPDATE store.TB_USUARIO SET rol = ?, nombre_usuario = ?, nombre = ?, apellido = ?, edad = ?, fecha_nac = ?, id_departamento = ?, id_municipio = ?, direccion_residencia = ?, estado = ? WEHRE id_usuario = ?";


	@Override
	public int saveEscuela(Usuario usuario) {
		SimpleJdbcInsert jdbcInsert1 = new SimpleJdbcInsert(jdbcTemplate).withSchemaName("TB_DEPARTAMENTO").withTableName("TB_CENTROS_ESCOLARES").usingGeneratedKeyColumns("id_departamento");
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("rol", usuario.getRol());
		parametros.put("nombre_usuario", usuario.getNombre());
		parametros.put("apellido", usuario.getApellido());
		parametros.put("edad", usuario.getEdad());
		parametros.put("fecha_nac", usuario.getFecha_nac());
		parametros.put("direccion_residencia", usuario.getDireccion_residencia());
		parametros.put("estado", usuario.getEstadoDelegate());
		
		
		Number id_genered1 = jdbcInsert1.executeAndReturnKey(parametros);
		
		return id_genered1.intValue();
	}

	@Override
	public void updateEscuela(Usuario usuario) {
		// TODO Auto-generated method stub
		Object[] parametros = new Object [] {usuario.getId_usuario(), usuario.getRol() ,usuario.getNombre(), usuario.getApellido(), usuario.getEdad(), usuario.getFecha_nac(), usuario.getId_departamento(), usuario.getId_municipio(), usuario.getDireccion_residencia(), usuario.getEstadoDelegate()};
		jdbcTemplate.update(sql,parametros);
	}

}
