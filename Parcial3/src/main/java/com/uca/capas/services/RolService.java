package com.uca.capas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Rol;

public interface RolService {

	public List<Rol> findAll() throws DataAccessException;

	public Rol findOne(Integer rol_id) throws DataAccessException;

}
