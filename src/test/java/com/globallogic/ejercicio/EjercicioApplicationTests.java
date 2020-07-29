package com.globallogic.ejercicio;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.ejercicio.controller.RegistrarUsuarioController;
import com.globallogic.ejercicio.controller.security.AuthenticationServer;
import com.globallogic.ejercicio.persistencia.entity.Usuario;
import com.globallogic.ejercicio.service.RegistrarService;
import com.globallogic.ejercicio.service.dto.ResponseDTO;
import com.globallogic.ejercicio.service.exception.EjercicioException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EjercicioApplication.class)
public class EjercicioApplicationTests {

	@InjectMocks
	private RegistrarUsuarioController registrarUsuarioController;

	@Mock
	private AuthenticationServer authenticationServer;

	@Mock
	private RegistrarService registrarService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void registrarUsuario_ok() throws EjercicioException {
		
		ResponseDTO responseDTO = new ResponseDTO("uuid", new Date(), new Date(), new Date(), "token", true);
		
		Mockito.when(registrarService.registrarUsuario(Matchers.any(Usuario.class), Matchers.any(String.class))).
		thenReturn(responseDTO);

		assertNotNull(registrarUsuarioController.registrarUsuario(new Usuario(), Mockito.mock(HttpServletResponse.class)));

	}
	
	@Test
	public void registrarUsuario_throwEjercicio() throws EjercicioException {
		
//		ResponseDTO responseDTO = new ResponseDTO("uuid", new Date(), new Date(), new Date(), "token", true);
		
		Mockito.when(registrarService.registrarUsuario(Matchers.any(Usuario.class), Matchers.any(String.class))).
			thenThrow(EjercicioException.class);

		assertNotNull(registrarUsuarioController.registrarUsuario(new Usuario(), Mockito.mock(HttpServletResponse.class)));

	}

}
