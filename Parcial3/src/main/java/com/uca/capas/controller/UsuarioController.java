package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.uca.capas.domain.Usuario;
import com.uca.capas.services.RolService;
import com.uca.capas.services.UserService;
import com.uca.capas.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UserService userService;
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolService rolService;
	
	@RequestMapping("/login")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("login");
		
		return mav;
	}
	@RequestMapping("/formLogin")
	public ModelAndView categorias( @ModelAttribute Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("formLogin");
		
		return mav;
	}
	@RequestMapping("/random")
	public ModelAndView categori( ) {
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("random");
		
		return mav;
	}
	@GetMapping(value = "/login")
	public ModelAndView lohin( ) {
	ModelAndView mav = new ModelAndView();
	return mav;
 
        
    }
 
    @GetMapping(value = "/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
    
	@PostMapping("/saveUsuario")
	public ModelAndView saveUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<Usuario> usuarios = null;
			usuarios=usuarioService.findAll();
			mav.addObject("usuarios",usuarios);
			mav.setViewName("random");
		} else {
			usuarioService.save(usuario);
			usuario = new Usuario();
			mav.addObject("usuario",usuario);

			mav.setViewName("coordiSucess");
			
			
		}
		return mav;
	}

}
