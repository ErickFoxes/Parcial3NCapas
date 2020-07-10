package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Escuelas;
import com.uca.capas.domain.Materias;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {
	
	@Autowired
	private CentroEscolarService centroEscolarService;
	private MateriaService materiaService;
	private UsuarioService usuarioService;
	
	//inicio
	@RequestMapping ("/")
	public ModelAndView Main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Materias");
		return mav;
	}
	
	//*** USUARIO ***
	
	//--Mostar uno--
	@RequestMapping (value = "/mostrarUnaUsuario", method = RequestMethod.POST)
	public ModelAndView findOneUsuario(@RequestParam (value = "codigo") Integer id) {
		ModelAndView mav = new ModelAndView();
		Usuario usuario = usuarioService.findOneUser(id);
		
		mav.addObject("usuario", usuario);
		mav.setViewName("Usuarios");
		return mav;
	}

	//--Guardar nuevo--
	@RequestMapping ("/guardarUsuarios")
	public ModelAndView guardar(@Valid @ModelAttribute Usuario usuario, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("AñadirUsuario");
		}
		else {
			usuarioService.saveUsuario(usuario);;
			List<Usuario> usuarios = null;
			try {
				usuarios= usuarioService.findAllUsers();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("usuario", usuario);
			mav.setViewName("Usuarios");
		}
		
		return mav;
	}
	
	//--Actualizar--
	@RequestMapping ("/actualizarUsuario")
	public ModelAndView updateMateria(@Valid @ModelAttribute Usuario Usuario, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("ActualizarUsuario");
		}
		else {
			usuarioService.updateUsuario(Usuario);
			List<Usuario> usuarios = null;
			try {
				usuarios= usuarioService.findAllUsers();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("usuarios", usuarios);
			mav.setViewName("Usuarios");
		}
		
		return mav;
	}
	
	//*** MATERIA ***
	
	//--Mostar uno--
	@RequestMapping (value = "/mostrarUnaMateria", method = RequestMethod.POST)
	public ModelAndView findOneMateria(@RequestParam (value = "codigo") Integer id) {
		ModelAndView mav = new ModelAndView();
		Materias materia = materiaService.findSubject(id);
		
		mav.addObject("materia", materia);
		mav.setViewName("Materias");
		return mav;
	}

	//--Guardar nuevo--
	@RequestMapping ("/guardarMateria")
	public ModelAndView guardar(@Valid @ModelAttribute Materias materia, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("AñadirMateria");
		}
		else {
			materiaService.saveMateria(materia);;
			List<Materias> materias = null;
			try {
				materias= materiaService.findAllSubjects();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("materia", materia);
			mav.setViewName("Materias");
		}
		
		return mav;
	}
	
	//--Actualizar--
	@RequestMapping ("/actualizarMateria")
	public ModelAndView updateMateria(@Valid @ModelAttribute Materias materia, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("ActualizarMateria");
		}
		else {
			materiaService.updateMateria(materia);
			List<Materias> materias = null;
			try {
				materias= materiaService.findAllSubjects();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("materias", materias);
			mav.setViewName("Materias");
		}

		return mav;
	}
	
	//*** CENTRO ESCOLAR ***

	//--Mostar uno--
	@RequestMapping (value = "/mostrarUnaCentroEscolar", method = RequestMethod.POST)
	public ModelAndView findOneEscuela(@RequestParam (value = "codigo") Integer id) {
		ModelAndView mav = new ModelAndView();
		Escuelas escuela = centroEscolarService.findOneSchool(id);
		mav.addObject("escuela", escuela);
		mav.setViewName("Escuelas");
		return mav;
	}

	//--Guardar nuevo--
	@RequestMapping ("/guardarCentroEscolar")
	public ModelAndView guardarEscuela(@Valid @ModelAttribute Escuelas escuela, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("AñadirMateria");
		}
		else {
			centroEscolarService.saveEscuela(escuela);
			List<Escuelas> escuelas = null;
			try {
				escuelas = centroEscolarService.findAllSchools();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("escuela", escuela);
			mav.setViewName("Escuelas");
		}
		
		return mav;
	}
	
	//--Actualizar--
	@RequestMapping ("/actualizarCentroEscolar")
	public ModelAndView updateEscuela(@Valid @ModelAttribute Escuelas escuela, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("ActualizarMateria");
		}
		else {
			centroEscolarService.updateEscuela(escuela);
			List<Escuelas> escuelas = null;
			try {
				escuelas = centroEscolarService.findAllSchools();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("escuelas", escuelas);
			mav.setViewName("Escuelas");
		}

		return mav;
	}



}
