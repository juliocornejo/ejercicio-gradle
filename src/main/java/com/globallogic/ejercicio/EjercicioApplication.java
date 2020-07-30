package com.globallogic.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by julio cornejo on 29-07-19.
 */

@SpringBootApplication
public class EjercicioApplication {
	
	public static void main(String[] args) {
//		new Thread(() -> System.out.println("Inicio de la aplicacion")).start();
		
		SpringApplication.run(EjercicioApplication.class, args);
	}

}
