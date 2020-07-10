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
import com.uca.capas.domain.Notas;
import com.uca.capas.service.DepartamentosService;
import com.uca.capas.service.EscuelasService;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MunicipiosService;
import com.uca.capas.service.NotasService;

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
	
	@Autowired
	private NotasService notasService;
	
	//Menu principal expediente
	/*@RequestMapping("/indexExpediente")
	public ModelAndView indexLaboratorio8() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Estudiante/indexEstudiante");
		return mav;
	}*/
	@RequestMapping("/index")
	public ModelAndView inicio1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView ingresarNota1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("buscarAlumno");
		return mav;
	}
	
	@RequestMapping("/buscar2")
	public ModelAndView inicio2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admi");
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
			//imprimiendo que el expediente fue ingresado con exito uwu
			mav.addObject("ExpedienteS", "Expediente creado con exito");
			mav.setViewName("buscarAlumno");
		}
		
		return mav;
		
	}
	
	//save para actualizar uwu
	@RequestMapping(value = "/actExpediente" )
	public ModelAndView actExpediente(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result) {
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
			
			mav.setViewName("Estudiante/actualizarEstudiante");
		}
		
		else {
			estudianteService.save(estudiante);
			//imprimiendo que el expediente fue actualizado con exito uwu
			mav.addObject("ExpedienteA", "Expediente actualizado con exito");
			mav.setViewName("buscarAlumno");
		}
		
		return mav;
		
	}
	
	@RequestMapping(value = "/actualizarEstudiante", method = RequestMethod.POST)
	public ModelAndView actualizar(@RequestParam(value = "id_estudiante") int id) {
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
			e.setPromedio(0.0);
			List<Notas> nota = null;
			nota=notasService.filtrarPorReprobados(e.getId_estudiante());
			e.setReprobados(nota.size());
			
			nota=notasService.filtrarPorAprobados(e.getId_estudiante());
			e.setAprobados(nota.size());
			
			List<Notas> nota2 = null;
			nota2=notasService.filtrarPorId(e);

			nota2.forEach((n) -> {
					e.setPromedio((e.getPromedio()+n.getNota()));
				
			}); 
			e.setPromedio(e.getPromedio()/nota2.size());
		}); 
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
