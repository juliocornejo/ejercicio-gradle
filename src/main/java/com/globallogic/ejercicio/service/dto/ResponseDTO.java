package com.globallogic.ejercicio.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by julio cornejo on 29-07-19.
 */
public class ResponseDTO implements Serializable{

	private static final long serialVersionUID = 1303847146230804414L;
	
	private String id;
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private Boolean isActive;
	
	public ResponseDTO(String id, Date created, Date modified, Date last_login, String token, Boolean isActive) {
		super();
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.token = token;
		this.isActive = isActive;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
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
	
}
