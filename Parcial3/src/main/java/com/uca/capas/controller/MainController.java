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

import com.uca.capas.domain.Escuela;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {
	
	@Autowired
	private CentroEscolarService centroEscolarService;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CentroEscolarService escuelaService;
	
	//inicio
	@RequestMapping ("/")
	public ModelAndView inicio() { 
		ModelAndView mav = new ModelAndView();
		List<Materia> materiasSelect = materiaService.findAllSubjects();
		mav.addObject("materia", materiasSelect );
		mav.setViewName("Materias"); 
		return mav;
	}

	//paginas
	@RequestMapping ("/AgregarMateria")
	public ModelAndView addMateria(Materia materia) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("materia", materia);
		mav.setViewName("AgregarMateria");
		return mav;
	}
	
	@RequestMapping ("/AgregarUsuario")
	public ModelAndView addUsuario(Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", usuario);
		mav.setViewName("AgregarUsuario");
		return mav;
	}
	
	@RequestMapping ("/AgregarEscuela")
	public ModelAndView addEscuela(Escuela escuela) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("escuela", escuela);
		mav.setViewName("AgregarCE");
		return mav;
	}
	
	@RequestMapping ("/EditarMateria")
	public ModelAndView EditMateria(Materia materia) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("materia", materia);
		mav.setViewName("ActualizarMateria");
		return mav;
	}
	
	@RequestMapping ("/EditarUsuario")
	public ModelAndView editUsuario(Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", usuario);
		mav.setViewName("ActualizarUsuario");
		return mav;
	}
	
	@RequestMapping ("/EditarEscuela")
	public ModelAndView editEscuela(Escuela escuela) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("escuela", escuela);
		mav.setViewName("ActualizarCE");
		return mav;
	}
	
	
	//*** USUARIO ***
	
	//--Mostar uno--
	@RequestMapping (value = "/mostrarUnUsuario", method = RequestMethod.POST)
	public ModelAndView findOneUsuario(@RequestParam (value = "codigo") Integer id) {
		ModelAndView mav = new ModelAndView();
		Usuario usuario = usuarioService.findOneUser(id);
		
		mav.addObject("usuario", usuario);
		mav.setViewName("Usuarios");
		return mav;
	}

	//--Guardar nuevo--
	@RequestMapping ("/guardarUsuario")
	public ModelAndView guardarU(@Valid @ModelAttribute Usuario usuarios, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("AgregarMateria");
		}
		else {
			usuarioService.saveUsuario(usuarios);
			List<Usuario> usuario = null;
			try {
				usuario = usuarioService.findAllUsers(); 
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
		@RequestMapping ("/actualizarUsuario2")
		public ModelAndView updateU2(@RequestParam(value = "id_usuario") int usuario) {
			ModelAndView mav = new ModelAndView();
			Usuario user = null;
			user = usuarioService.findOneUser(usuario);
			mav.addObject("usuario", user);
			mav.setViewName("ActualizarUsuario");
			return mav;
		}
	
	
	//--Actualizar--
	@RequestMapping ("/actualizarUsuario")
	public ModelAndView updateU(@Valid @ModelAttribute Usuario usuario, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Usuario> usuarioSelect = null;
		if(result.hasErrors()) {
			mav.setViewName("ActualizarUsuario");
		}
		else {
			usuarioService.saveUsuario(usuario);
			try {
				usuarioSelect = usuarioService.findAllUsers();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("usuario", usuarioSelect);
			mav.setViewName("Usuarios");
		}

		return mav;
	}
	//*** MATERIA ***
	
	
	//--Mostar uno--
	@RequestMapping (value = "/mostrarUnaMateria", method = RequestMethod.POST)
	public ModelAndView findOneMateria(@RequestParam (value = "codigo") Integer id) {
		ModelAndView mav = new ModelAndView();
		Materia materia = materiaService.findSubject(id);
		
		mav.addObject("materia", materia);
		mav.setViewName("Materias");
		return mav;
	}

	//--Guardar nuevo--
	@RequestMapping ("/guardarMateria")
	public ModelAndView guardarM(@Valid @ModelAttribute Materia materias, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("AgregarMateria");
		}
		else {
			materiaService.saveMateria(materias);
			List<Materia> materia = null;
			try {
				materia = materiaService.findAllSubjects(); 
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
		@RequestMapping ("/actualizarMateria2")
		public ModelAndView updateM2(@RequestParam(value = "id_materia") int materia) {
			ModelAndView mav = new ModelAndView();
			Materia mate = null;
			mate = materiaService.findSubject(materia);
			mav.addObject("materia", mate);
			mav.setViewName("ActualizarMateria");
			return mav;
		}
	
	
	//--Actualizar--
	@RequestMapping ("/actualizarMateria")
	public ModelAndView updateM(@Valid @ModelAttribute Materia materia, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Materia> materiasSelect = null;
		if(result.hasErrors()) {
			mav.setViewName("ActualizarMateria");
		}
		else {
			materiaService.saveMateria(materia);
			try {
				materiasSelect= materiaService.findAllSubjects();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("materia", materiasSelect);
			mav.setViewName("Materias");
		}

		return mav;
	}
	
	//*** CENTRO ESCOLAR ***

	//--Mostar uno--
		@RequestMapping (value = "/mostrarUnaEscuela", method = RequestMethod.POST)
		public ModelAndView findOneE(@RequestParam (value = "codigo") Integer id) {
			ModelAndView mav = new ModelAndView();
			Escuela escuela = escuelaService.findOneSchool(id);
			
			mav.addObject("escuela", escuela);
			mav.setViewName("Escuelas");
			return mav;
		}

		//--Guardar nuevo--
		@RequestMapping ("/guardarEscuela")
		public ModelAndView guardarE(@Valid @ModelAttribute Escuela escuelas, BindingResult result) {
			ModelAndView mav = new ModelAndView();
			
			if(result.hasErrors()) {
				mav.setViewName("AgregarEscuela");
			}
			else {
				escuelaService.saveEscuela(escuelas);
				List<Escuela> escuela = null;
				try {
					escuela = escuelaService.findAllSchools(); 
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
			@RequestMapping ("/actualizarEscuela2")
			public ModelAndView updateE2(@RequestParam(value = "id_materia") int materia) {
				ModelAndView mav = new ModelAndView();
				Escuela escuela = null;
				escuela = escuelaService.findOneSchool(materia);
				mav.addObject("materia", escuela);
				mav.setViewName("ActualizarMateria");
				return mav;
			}
		
		
		//--Actualizar--
		@RequestMapping ("/actualizarEscuela")
		public ModelAndView updateE(@Valid @ModelAttribute Escuela escuela, BindingResult result) {
			ModelAndView mav = new ModelAndView();
			List<Escuela> escuelaSelect = null;
			if(result.hasErrors()) {
				mav.setViewName("ActualizarEscuela");
			}
			else {
				escuelaService.saveEscuela(escuela);
				try {
					escuelaSelect= escuelaService.findAllSchools();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				mav.addObject("escuela", escuelaSelect);
				mav.setViewName("Escuelas");
			}

			return mav;
		}



}