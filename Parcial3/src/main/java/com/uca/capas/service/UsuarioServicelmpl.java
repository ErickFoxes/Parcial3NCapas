package com.uca.capas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.UsuarioDAO;
import com.uca.capas.domain.Usuario;

@Service
public class UsuarioServicelmpl implements  UsuarioService{
	
	@Autowired
	UsuarioDAO usuarioDAO;

	@Override
	public int saveEscuela(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDAO.saveEscuela(usuario);
	}

	@Override
	public void updateEscuela(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDAO.updateEscuela(usuario);
	}
}
