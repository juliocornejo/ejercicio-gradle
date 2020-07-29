package com.globallogic.ejercicio.service.exception;

/**
 * Created by julio cornejo on 29-07-19.
 */
public class EjercicioException extends RuntimeException{

	private static final long serialVersionUID = 7672936385153673862L;

	public EjercicioException(){
		super();
	}

	public EjercicioException(String message){
		super(message);
	}
	
	public EjercicioException(String message, Throwable cause){
		super(message, cause);
	}
	
	
	public EjercicioException(Throwable cause){
		super(cause);
	}
}