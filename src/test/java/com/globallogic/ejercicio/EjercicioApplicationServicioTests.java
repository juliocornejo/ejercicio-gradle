package com.globallogic.ejercicio;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.ejercicio.controller.RegistrarUsuarioController;
import com.globallogic.ejercicio.controller.security.AuthenticationServer;
import com.globallogic.ejercicio.persistencia.dao.TransaccionalDAO;
import com.globallogic.ejercicio.persistencia.entity.Telefono;
import com.globallogic.ejercicio.persistencia.entity.Usuario;
import com.globallogic.ejercicio.service.RegistrarService;
import com.globallogic.ejercicio.service.dto.ResponseDTO;
import com.globallogic.ejercicio.service.exception.EjercicioException;
import com.globallogic.ejercicio.service.impl.RegistrarServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EjercicioApplication.class)
public class EjercicioApplicationServicioTests {

//	@Autowired
	private RegistrarService registrarService;

	@Mock
	private TransaccionalDAO registerDAO;
	
	@Mock
	private PasswordEncoder passwordEncoder;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		registrarService = new RegistrarServiceImpl(registerDAO, passwordEncoder);
	}

	@Test
	public void registrarUsuario_ok() throws EjercicioException {
		
		String contrasenha = "cntraseñaencriptada";
		Telefono telefono = new Telefono("number", "citycode", "contrycode");
		
		List<Telefono> phones = new ArrayList<Telefono>(); 
		phones.add(telefono);
		
		Usuario usuario = new Usuario("julio_cornejo", "julio@julio.com", "2A5%/$#52345AEWSa", phones); 
		
		doNothing().when(registerDAO).insert(Matchers.any(Usuario.class));
		
		Mockito.when(passwordEncoder.encode(Matchers.any(String.class))).thenReturn(contrasenha);

		assertNotNull(registrarService.registrarUsuario(usuario, "token"));

	}
	
	@Test(expected = EjercicioException.class)
	public void registrarUsuario_contrasenhaInsegura() throws EjercicioException {
		
		String contrasenha = "cntraseñaencriptada";
		Telefono telefono = new Telefono("number", "citycode", "contrycode");
		
		List<Telefono> phones = new ArrayList<Telefono>(); 
		phones.add(telefono);
		
		Usuario usuario = new Usuario("julio_cornejo", "julio@julio.com", "2A55", phones); 
		
		doNothing().when(registerDAO).insert(Matchers.any(Usuario.class));
		
		Mockito.when(passwordEncoder.encode(Matchers.any(String.class))).thenReturn(contrasenha);

		assertNotNull(registrarService.registrarUsuario(usuario, "token"));

	}
	
	@Test(expected = EjercicioException.class)
	public void registrarUsuario_formatoEmailInvalido() throws EjercicioException {
		
		String contrasenha = "cntraseñaencriptada";
		Telefono telefono = new Telefono("number", "citycode", "contrycode");
		
		List<Telefono> phones = new ArrayList<Telefono>(); 
		phones.add(telefono);
		
		Usuario usuario = new Usuario("julio_cornejo", "julio_julio.com", "2A5%/$#52345AEWSa", phones); 
		
		doNothing().when(registerDAO).insert(Matchers.any(Usuario.class));
		
		Mockito.when(passwordEncoder.encode(Matchers.any(String.class))).thenReturn(contrasenha);

		assertNotNull(registrarService.registrarUsuario(usuario, "token"));

	}
	
	@Test(expected = EjercicioException.class)
	public void registrarUsuario_emailExiste() throws EjercicioException {
		
		String contrasenha = "cntraseñaencriptada";
		Telefono telefono = new Telefono("number", "citycode", "contrycode");
		
		List<Telefono> phones = new ArrayList<Telefono>(); 
		phones.add(telefono);
		
		Usuario usuario = new Usuario("julio_cornejo", "julio@julio.com", "2A5%/$#52345AEWSa", phones);  
		
		doNothing().when(registerDAO).insert(Matchers.any(Usuario.class));
		
		Mockito.when(passwordEncoder.encode(Matchers.any(String.class))).thenReturn(contrasenha);

		assertNotNull(registrarService.registrarUsuario(usuario, "token"));
		
		assertNotNull(registrarService.registrarUsuario(usuario, "token"));

	}
	
//	@Test
//	public void registrarUsuario_throwEjercicio() throws EjercicioException {
//		
////		ResponseDTO responseDTO = new ResponseDTO("uuid", new Date(), new Date(), new Date(), "token", true);
//		
//		Mockito.when(registrarService.registrarUsuario(Matchers.any(Usuario.class), Matchers.any(String.class))).
//			thenThrow(EjercicioException.class);
//
//		assertNotNull(registrarUsuarioController.registrarUsuario(new Usuario(), Mockito.mock(HttpServletResponse.class)));
//
//	}

}
