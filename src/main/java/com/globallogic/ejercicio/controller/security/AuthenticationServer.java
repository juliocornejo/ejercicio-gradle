package com.globallogic.ejercicio.controller.security;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
//import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Created by julio cornejo on 29-07-19.
 */

@Component
public class AuthenticationServer {
  
	@Value("${authenticacion.expiracion}")
	private String expiracion;
	
	@Value("${authenticacion.secret}")
	private String secretoFirma;

	@Value("${authenticacion.tipo.token}")
	private String tipoToken;

	@Value("${authenticacion.header}")
	private String header;
	
	
  public void addTokenAuthentication(HttpServletResponse headerResponse, String username) {
    String tokenJWT = Jwts.builder()
        .setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expiracion)))
        .signWith(SignatureAlgorithm.HS512, secretoFirma)
        .compact();
    
    headerResponse.addHeader(header, tipoToken + tokenJWT);
  }
  
//  public Date getExpirationDateFromToken(String token) {
//	  Date date = Jwts.parser()         
//      .setSigningKey(DatatypeConverter.parseBase64Binary(secretoFirma))
//      .parseClaimsJws(token).getBody().getExpiration();
//	  return date;
//  }
}