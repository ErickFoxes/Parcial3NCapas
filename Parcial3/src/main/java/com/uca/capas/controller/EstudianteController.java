package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materias;
import com.uca.capas.domain.Notas;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.NotasService;

@Controller
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private NotasService notasService;
	
	@RequestMapping("/buscar")
	public ModelAndView ingresarNota1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("buscarAlumno");
		return mav;
	}
	
	@RequestMapping(value = "/buscarEstudiante", method = RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value="dato") String dato, @RequestParam(value="buscarPor") String dato2) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiante = null;
		try {
			if(dato2.equals("Nombre")) {
				estudiante = estudianteService.filtrarPorNombre(dato);
			} else if(dato2.equals("Apellido")) {
				estudiante = estudianteService.filtrarPorApellido(dato);
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}

		
		estudiante.forEach((e) -> {
			List<Notas> nota = null;
			nota=notasService.filtrarPorReprobados(e.getId_estudiante());
			e.setReprobados(nota.size());
			
			nota=notasService.filtrarPorAprobados(e.getId_estudiante());
			e.setAprobados(nota.size());
			
		}	); 
		mav.addObject("estudiante",estudiante);
		mav.setViewName("mostrarAlumnos");
		return mav;
	}
	
	// mostrar notas
		@RequestMapping(value = "/mostrarEstdiantes")
		public ModelAndView findAll() {
			ModelAndView mav = new ModelAndView();
			List<Estudiante> estudiantes = null;
			
			try {
				
				estudiantes = estudianteService.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("mostrarAlumnos");
			return mav;
		}
}
