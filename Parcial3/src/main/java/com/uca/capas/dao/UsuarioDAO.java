package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Usuario;

public interface UsuarioDAO {
	
	public List<Usuario> findAllUsers() throws DataAccessException;
	
	public Usuario findOneUser(Integer code) throws DataAccessException;

	public void saveUsuario(Usuario usuario) throws DataAccessException;
	
	public void updateUsuario(Usuario usuario) throws DataAccessException;
}
