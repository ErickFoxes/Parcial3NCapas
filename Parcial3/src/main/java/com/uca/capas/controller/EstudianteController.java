package com.uca.capas.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Departamentos;
import com.uca.capas.domain.Escuelas;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Municipios;
import com.uca.capas.service.DepartamentosService;
import com.uca.capas.service.EscuelasService;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MunicipiosService;

@Controller
public class EstudianteController {
	
	@Autowired
	private DepartamentosService departamentoService;
	
	@Autowired
	private MunicipiosService municipioService;
	
	@Autowired
	private EscuelasService escuelaService;
	
	@Autowired
	private EstudianteService estudianteService;
	
	//Menu principal expediente
	@RequestMapping("/indexExpediente")
	public ModelAndView indexLaboratorio8() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Estudiante/indexEstudiante");
		
		return mav;
		
	}
	
	@GetMapping("/insertExpediente")
	public ModelAndView nuevoEstudiante() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		
		List <Departamentos> departamentos = null;
		List <Municipios> municipios = null;
		List <Escuelas> escuelas = null;
		try{
			departamentos = departamentoService.findAll();
			municipios = municipioService.findAll();
			escuelas = escuelaService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("departamentos", departamentos);
		mav.addObject("municipios", municipios);
		mav.addObject("escuelas", escuelas);
		
		mav.setViewName("Estudiante/agregarEstudiante");
		return mav;
	}
			
	@RequestMapping(value = "/saveExpediente" )
	public ModelAndView saveExpediente(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List <Departamentos> departamentos = null;
			List <Municipios> municipios = null;
			List <Escuelas> escuelas = null;
			try{
				departamentos = departamentoService.findAll();
				municipios = municipioService.findAll();
				escuelas = escuelaService.findAll();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			mav.addObject("estudiante", estudiante);
			mav.addObject("departamentos", departamentos);
			mav.addObject("municipios", municipios);
			mav.addObject("escuelas", escuelas);
			
			mav.setViewName("Estudiante/agregarEstudiante");
		}
		
		else {
			estudianteService.save(estudiante);
			mav.setViewName("Estudiante/indexEstudiante");
		}
		
		return mav;
		
	}
	
	@RequestMapping(value = "/actualizarEstudiante", method = RequestMethod.POST)
	public ModelAndView actualizar(@RequestParam(value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		
		List <Departamentos> departamentos = null;
		List <Municipios> municipios = null;
		List <Escuelas> escuelas = null;
		try{
			departamentos = departamentoService.findAll();
			municipios = municipioService.findAll();
			escuelas = escuelaService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("departamentos", departamentos);
		mav.addObject("municipios", municipios);
		mav.addObject("escuelas", escuelas);
		
		
		Estudiante estudiante = estudianteService.findOne(id);
		mav.addObject("estudiante", estudiante);
		mav.setViewName("Estudiante/actualizarEstudiante");
		
		return mav;
		
	}
	
	
}
