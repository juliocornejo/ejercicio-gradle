package com.globallogic.ejercicio.persistencia.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by julio cornejo on 29-07-19.
 */

@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String uuid;
	private String name;
	private String email;
	private String password;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Telefono> phones;
	
	private Date created;
	private Date modified;
	private Date lastLogin;
	private String token;
	private Boolean isActive;
	
	public Usuario() {
		super();
	}
	public Usuario(String name, String email, String password, List<Telefono> phones) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Telefono> getPhones() {
		return phones;
	}
	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "{\"uuid\":\""+uuid+ "\", \"name\":\"" + name + "\", \"email:\"" + email + "\", password:\"" + password + "\","
				+ "\" created:\"" + created + "\", modified:\"" + modified + "\", lastLogin:\"" + lastLogin + "\","
				+ "\" token:\"" + token + ", \"isActive:\""	+ isActive + ", \"phones:\"" + phones + "}";
	}
}
