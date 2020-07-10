package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.UsuarioDAO;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepo;

@Service
public class UsuarioServicelmpl implements  UsuarioService{
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	UsuarioRepo usaurioRepo;

	@Override
	public List<Usuario> findAllUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return usaurioRepo.findAll();
	}

	@Override
	public Usuario findOneUser(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return usaurioRepo.getOne(code);
	}

	@Override
	@Transactional
	public void saveUsuario(Usuario usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		usaurioRepo.save(usuario);
	}

	@Override
	@Transactional
	public void updateUsuario(Usuario usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		usuarioDAO.updateUsuario(usuario);
	}


}
