package com.globallogic.ejercicio.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.ejercicio.controller.security.AuthenticationServer;
import com.globallogic.ejercicio.persistencia.entity.Usuario;
import com.globallogic.ejercicio.service.RegistrarService;
import com.globallogic.ejercicio.service.dto.ResponseDTO;
import com.globallogic.ejercicio.service.exception.EjercicioException;
import com.globallogic.ejercicio.service.impl.RegisterServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

/**
 * Created by julio cornejo on 29-07-19.
 */

@RestController
public class RegistrarUsuarioController {
	
	private Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);
	
	@Autowired
	private AuthenticationServer authenticationServer;
	
	@Autowired
	private RegistrarService registrarService;
	
//	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String>  prueba()  throws EjercicioException{
//		return new ResponseEntity<>("texto", HttpStatus.OK);
//	}
	
	@PostMapping(path = "/registrar-usuario")
	public ResponseEntity<ResponseDTO> registrarUsuario(@RequestBody Usuario usuario,HttpServletResponse response) 
			throws EjercicioException{
		
		LOGGER.info("registrarUsuario: {}", usuario);
		
		authenticationServer.addTokenAuthentication(response, usuario.getEmail());
		
		String token = response.getHeader("Authorization");
		
		return new ResponseEntity<>(registrarService.registrarUsuario(usuario, token),
				HttpStatus.OK);
	}
	
//	{
//		   "name" :"name",
//		   "email":"wata@walgo.cl",
//		   "password":"2A5a",
//		   "phones":[
//		       {
//		           "number" : "1234567"  ,
//		            "citycode" : "1" ,
//		            "contrycode" : "57"
//		       }
//		   ]
//		}
	
}
