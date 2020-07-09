package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.uca.capas.service.EstudianteService;

@Controller
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
}
