package com.uca.capas.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	//JDBC
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.tb_expediente");
		Query query = entityManager.createNativeQuery(sb.toString(),Estudiante.class);
		List<Estudiante> resulset = query.getResultList();
		
		return resulset;
		
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		return estudiante;
		
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		
		try {
			if(estudiante.getId_estudiante() == null) {
				entityManager.persist(estudiante);
			}
			else {
				entityManager.merge(estudiante);
				entityManager.flush();
			}
		} catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	//sentencia SQL para editar estudiante
	private static final String sql = "UPDATE public.tb_expediente SET  nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, carnet = ?, fecha_nac = ?, "
			+ "direccion_vivienda = ?, telefono,celular = ?, id_centro_escolar = ?, nombre_padre = ?, nombre_madre = ?, id_departamento = ?, id_municipio = ? WHERE id_expediente = ?";

	@Override
	public void updateEstudiante(Estudiante estudiante) {
		
		Object[] parametros = new Object[] { estudiante.getNombre1(), estudiante.getNombre2(), estudiante.getApellido1(), estudiante.getApellido2(),
				estudiante.getCarnet(), estudiante.getFecha_nac(), estudiante.getDireccion_vivienda(), estudiante.getTel(), estudiante.getCel(),
				estudiante.getEscuela(), estudiante.getNombre_padre(), estudiante.getNombre_madre(), estudiante.getDepartamento(), estudiante.getMunicipio() };
		jdbcTemplate.update(sql, parametros);
		
	}

	@Override
	public int insertEstudianteAutoId(Estudiante c) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
				.withSchemaName("public")
				.withTableName("tb_expediente")
				//PK
				.usingGeneratedKeyColumns("id_expediente");
		
		//Valores del insert
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre1", c.getNombre1());
		parametros.put("nombre2", c.getNombre2());
		parametros.put("apellido1", c.getApellido1());
		parametros.put("apellido2", c.getApellido2());
		parametros.put("carnet", c.getCarnet());
		parametros.put("apellido1", c.getApellido1());
		parametros.put("fecha_nac", c.getFecha_nac());
		parametros.put("direccion_vivienda", c.getDireccion_vivienda());
		parametros.put("telefono", c.getTel());
		parametros.put("celular",c.getCel());
		parametros.put("id_centro_escolar", c.getEscuela());
		parametros.put("nombre_padre", c.getNombre_padre());
		parametros.put("nombre_madre", c.getNombre_madre());
		parametros.put("id_departamento", c.getDepartamento());
		parametros.put("id_municipio", c.getMunicipio());
		
		//el metodo executeAndReturnKey devuelve la lave primaria generada en el insert
		Number id_generated = jdbcInsert.executeAndReturnKey(parametros);
		
		return id_generated.intValue();
	}

}
