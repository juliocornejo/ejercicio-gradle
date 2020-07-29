package com.globallogic.ejercicio.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.globallogic.ejercicio.persistencia.dao.TransaccionalDAO;
import com.globallogic.ejercicio.persistencia.entity.Usuario;
import com.globallogic.ejercicio.service.RegistrarService;
import com.globallogic.ejercicio.service.dto.ResponseDTO;
import com.globallogic.ejercicio.service.exception.EjercicioException;
import com.globallogic.ejercicio.service.utilidades.ValidacionPatrones;

/**
 * Created by julio cornejo on 29-07-19.
 */
@Service
public class RegisterServiceImpl implements RegistrarService {

	private Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);

//	@Autowired
	private TransaccionalDAO registerDAO;

//	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public RegisterServiceImpl(TransaccionalDAO registerDAO, PasswordEncoder passwordEncoder){
		this.registerDAO = registerDAO;
        this.passwordEncoder = passwordEncoder;
	}
	
	public ResponseDTO registrarUsuario(Usuario usuario, String token) throws EjercicioException{


		if(ValidacionPatrones.validarPatronSeguridadContrasenha(usuario.getPassword())) {
			if(ValidacionPatrones.validarPatronEmail(usuario.getEmail())) {
				
				registerDAO.buscar(usuario.getEmail());

				Date fechaRegistro = new Date();

				usuario.setUuid(ValidacionPatrones.uniqueUuid());

				usuario.setToken(token.replace("Bearer", "").trim());

				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

				usuario.setCreated(fechaRegistro);

				usuario.setModified(fechaRegistro);

				usuario.setLastLogin(fechaRegistro);

				usuario.setIsActive(true);

				registerDAO.insert(usuario);

				return new ResponseDTO(usuario.getUuid(), usuario.getCreated(), usuario.getModified(), usuario.getLastLogin(),
						usuario.getToken() , usuario.getIsActive());

			}else {
				LOGGER.error("error en validacion El formato del email es incorrecto");
				throw new EjercicioException("El formato del email es incorrecto");
			}
		}else {
			LOGGER.error("la contrasenha es debil");
			throw new EjercicioException("la contrasenha es debil");
		}
	}

}
