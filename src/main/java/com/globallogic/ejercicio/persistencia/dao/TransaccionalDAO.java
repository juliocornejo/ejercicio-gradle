package com.globallogic.ejercicio.persistencia.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.globallogic.ejercicio.persistencia.entity.Usuario;
import com.globallogic.ejercicio.service.exception.EjercicioException;

/**
 * Created by julio cornejo on 29-07-19.
 */

@Repository
@Transactional
public class TransaccionalDAO {
	
	private Logger LOGGER = LoggerFactory.getLogger(TransaccionalDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Usuario user) {
		entityManager.persist(user);
	}

	public void buscar(String email) throws EjercicioException{
		
		try {

			entityManager.createQuery(
					"SELECT u from Usuario u WHERE u.email = :email", Usuario.class).

					setParameter("email", email).getSingleResult();

			LOGGER.error("error en validacion El correo ya registrado");
			throw new EjercicioException("El correo ya registrado");

		}catch(NoResultException e) {
			LOGGER.error("no existe usuario asignado a {}", email);
		}
		
	}
}
