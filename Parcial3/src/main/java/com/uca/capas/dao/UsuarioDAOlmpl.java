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

import com.uca.capas.domain.Usuario;

@Repository
public class UsuarioDAOlmpl implements UsuarioDAO {
	
	@Autowired	
	JdbcTemplate jdbcTemplate;
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	public static final String sql = "UPDATE public.TB_USUARIO SET rol = ?, nombre_usuario = ?, pass = ?, nombre = ?, apellido = ?, edad = ?, fecha_nac = ?, id_departamento = ?, id_municipio = ?, direccion_residencia = ?, estado = ? WEHRE id_usuario = ?";

	@Override
	public List<Usuario> findAllUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.TB_USUARIO");
		
		Query query = entityManager.createNativeQuery(sb.toString(),Usuario.class);
		List<Usuario>result = query.getResultList();
		return result;
	}

	@Override
	public Usuario findOneUser(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Usuario usuario = entityManager.find(Usuario.class, code);
		return usuario;
	}

	@Override
	@Transactional
	public void saveUsuario(Usuario usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(usuario.getId_usuario() == null){
				entityManager.persist(usuario);
			}
			else {
				entityManager.merge(usuario);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void updateUsuario(Usuario usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		Object[] parametros = new Object [] {usuario.getId_usuario(), usuario.getId_rol(), usuario.getNombre_usuario(), usuario.getPass() ,usuario.getNombre(), usuario.getApellido(), usuario.getEdad(), usuario.getFecha_nac(), usuario.getId_departamento(), usuario.getId_municipio(), usuario.getDireccion_residencia(), usuario.getEstadoDelegate()};
		jdbcTemplate.update(sql,parametros);
	}


	
}
