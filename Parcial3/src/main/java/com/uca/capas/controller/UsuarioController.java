package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.uca.capas.domain.Usuario;
import com.uca.capas.services.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioService userService;
	
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

}
