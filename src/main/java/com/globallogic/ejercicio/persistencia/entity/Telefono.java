package com.globallogic.ejercicio.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by julio cornejo on 29-07-19.
 */
@Entity
public class Telefono implements Serializable{

	private static final long serialVersionUID = 9047887944859264006L;
	@Id
	@GeneratedValue
	private Long id;
	private String number;
	private String citycode;
	private String contrycode;
	
	public Telefono(String number, String citycode, String contrycode) {
		super();
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}

	public Telefono() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCitycode() {
		return citycode;
	}


	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}


	public String getContrycode() {
		return contrycode;
	}


	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}


//	public Usuario getUser() {
//		return user;
//	}
//
//
//	public void setUser(Usuario user) {
//		this.user = user;
//	}
	
	@Override
	public String toString() {
		return " { id=" + id + " ,number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode + "}";
	}
	
	
	
	
}
