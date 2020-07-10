package com.uca.capas.services;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll() throws DataAccessException;

	
	
	public void save(Usuario usuario) throws DataAccessException;

}
