package com.globallogic.ejercicio.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.ejercicio.persistencia.entity.Usuario;


/**
 * Created by julio cornejo on 29-07-19.
 */

public interface UserRepository extends JpaRepository<Usuario, String>{

	public Usuario findByEmail(String email);
}
