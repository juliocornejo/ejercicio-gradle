package com.globallogic.ejercicio.controller.configuracion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.globallogic.ejercicio.controller.security.AuthenticationServer;

/**
 * Created by julio cornejo on 29-07-19.
 */

@Configuration
public class ServiceBeanConf {
	
	@Bean
    public BCryptPasswordEncoder obtenerBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public AuthenticationServer obtenerTokenAuthenticationService() {
        return new AuthenticationServer();
    }
}
