package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Usuario;

public interface UsuarioService {

	public List<Usuario> findAllUsers() throws DataAccessException;
	
	public Usuario findOneUser(Integer code) throws DataAccessException;

	public void saveUsuario(Usuario usuario) throws DataAccessException;
	

}
