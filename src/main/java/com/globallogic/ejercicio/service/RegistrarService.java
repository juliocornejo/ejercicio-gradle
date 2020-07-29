package com.globallogic.ejercicio.service;

import com.globallogic.ejercicio.persistencia.entity.Usuario;
import com.globallogic.ejercicio.service.dto.ResponseDTO;
import com.globallogic.ejercicio.service.exception.EjercicioException;

/**
 * Created by julio cornejo on 29-07-19.
 */

public interface RegistrarService {

	public ResponseDTO registrarUsuario(Usuario usuario, String token) throws EjercicioException;

}
