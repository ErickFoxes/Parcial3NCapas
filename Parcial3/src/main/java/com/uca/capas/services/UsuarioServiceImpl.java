package com.uca.capas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.UsuarioDAO;
import com.uca.capas.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioDAO userDAO;
	
	@Autowired
	RolService rolService;

	@Override
	public List<Usuario> findAll() throws DataAccessException {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) throws DataAccessException {
	//	usuario.setRol(rolService.findOne(usuario.getRol_id()));
		userDAO.save(usuario);
	}

}
