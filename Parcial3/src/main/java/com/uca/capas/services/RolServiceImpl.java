package com.uca.capas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.RolDao;
import com.uca.capas.domain.Rol;

@Service
public class RolServiceImpl implements RolService {
	@Autowired
	RolDao rolDAO;

	@Override
	public List<Rol> findAll() throws DataAccessException {
		return rolDAO.findAll();
	}

	@Override
	public Rol findOne(Integer rol_id) throws DataAccessException {
		return rolDAO.findOne(rol_id);
	}
	

}
