package com.globallogic.ejercicio.service.utilidades;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by julio cornejo on 29-07-19.
 */
public class ValidacionPatrones {

	private static final String PATTERN_PASSWORD = "^(?=.*[A-Z])(?=.*[0-9].*[0-9])(?=.*[a-z]).{4,}$";
	
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static volatile SecureRandom numberGenerator = null;
    
	private static final long MSB = 0x8000000000000000L;
	
	public static boolean validarPatronEmail(String textoEmail)  {
		try {
			Pattern pattern = Pattern.compile(PATTERN_EMAIL);
			
			Matcher matcher = pattern.matcher(textoEmail);

			return matcher.matches();
		} catch (Exception e) {
			return false;
		}

	}
	
	public static boolean validarPatronSeguridadContrasenha(String textoPassword)  {
		try {
			Pattern pattern = Pattern.compile(PATTERN_PASSWORD);
			
			Matcher matcher = pattern.matcher(textoPassword);

			return matcher.matches();
		} catch (Exception e) {
			return false;
		}

	}
	
	public static String uniqueUuid() {
        SecureRandom ng = numberGenerator;
        if (ng == null) {
            numberGenerator = ng = new SecureRandom();
        }

        return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
    }
	
	


}
