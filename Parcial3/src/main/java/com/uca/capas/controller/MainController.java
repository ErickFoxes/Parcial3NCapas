package com.uca.capas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	//inicio
		@RequestMapping ("/")
		public ModelAndView Main() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("Materias");
			return mav;
		}

}
