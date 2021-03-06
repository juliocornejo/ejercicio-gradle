package com.globallogic.ejercicio.controller.exception;

import java.io.Serializable;

/**
 * Created by julio cornejo on 29-07-19.
 */
public class ResponseError implements Serializable {
	
	private static final long serialVersionUID = -1360021176413807221L;
	
	private String mensaje;

	public ResponseError() {
	}
	
	public ResponseError(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
