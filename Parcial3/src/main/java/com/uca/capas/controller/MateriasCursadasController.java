package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materias;
import com.uca.capas.domain.Notas;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriasService;
import com.uca.capas.service.NotasService;

@Controller
public class MateriasCursadasController {

	@Autowired
	private NotasService notasService;
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriasService materiasService;
	
	@RequestMapping("/ingresarnota")
	public ModelAndView ingresarNota1() {
		Notas notas = new Notas();
		List<Estudiante> estudianteSelect = estudianteService.findAll();
		List<Materias> materiaSelect = materiasService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("notas",notas);
		mav.addObject("estudianteSelect",estudianteSelect);
		mav.addObject("materiaSelect",materiaSelect);
		mav.setViewName("InsertarNotas");
		return mav;
	}
	
	// Ingresar notas
	@RequestMapping("/ingresarNotas")
	public ModelAndView ingresarNota2(@Valid @ModelAttribute Notas notas, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudianteSelect = estudianteService.findAll();
		List<Materias> materiaSelect = materiasService.findAll();
		mav.addObject("estudianteSelect",estudianteSelect);
		mav.addObject("materiaSelect",materiaSelect);
		if (result.hasErrors()) {
			mav.setViewName("InsertarNotas");
		} else {
			notasService.save(notas);
			mav.setViewName("buscarAlumno");
		}
		return mav;
	}

	// Modificar notas
	@RequestMapping("/modificarNotas")
	public ModelAndView modificar(@RequestParam(value = "id_estudiante") int nota) {
		ModelAndView mav = new ModelAndView();
		Notas notas = new Notas();
		
		List<Estudiante> estudianteSelect = estudianteService.findAll();
		List<Materias> materiaSelect = materiasService.findAll();
		mav.addObject("estudianteSelect",estudianteSelect);
		mav.addObject("materiaSelect",materiaSelect);

		notas = notasService.findOne(nota);
		mav.addObject("notas", notas);
		mav.setViewName("modificarNotas");
		return mav;
	}
	
	// Modificar notas
		@RequestMapping("/modificarNotas2")
		public ModelAndView modificar2(@Valid @ModelAttribute Notas notas, BindingResult result) {
			ModelAndView mav = new ModelAndView();
			List<Notas> notas2 = null;
			try {
				notas2 = notasService.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("notas", notas2);
			
			if (result.hasErrors()) {
				mav.setViewName("mostrarNotas");
			} else {
				notasService.save(notas);
				mav.setViewName("buscarAlumno");
			}

			return mav;
		}

		@RequestMapping("/mostrarnota")
		public ModelAndView mostrarnota(@RequestParam(value = "id_estudiante") int nota) {
			ModelAndView mav = new ModelAndView();
			List<Notas> notas = null;
			Estudiante est = estudianteService.findOne(nota);
			try {
				notas = notasService.filtrarPorId(est);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("notas", notas);
			mav.addObject("est", est);
			mav.setViewName("mostrarNotas");
			return mav;
		}	
		
	// mostrar notas
	@RequestMapping(value = "/mostrarNotas")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		List<Notas> notas = null;
		try {
			notas = notasService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("notas", notas);
		mav.setViewName("mostrarNotas");
		return mav;
	}
}
