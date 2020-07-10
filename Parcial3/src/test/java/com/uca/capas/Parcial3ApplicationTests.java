package com.uca.capas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;

@SpringBootTest
class Parcial3ApplicationTests {

	//@Autowired
		private UsuarioRepository repo;
		
		//@Autowired
		private BCryptPasswordEncoder encoder;
		
		@Test
		public void crearUsuarioTest() {
			Usuario us = new Usuario();
			us.setId_usuario(3);
			us.setUsername("codex");			
			us.setPass(encoder.encode("123"));		
			Usuario retorno = repo.save(us);
			
			assertTrue(retorno.getPass().equalsIgnoreCase(us.getPass()));
		}

	}