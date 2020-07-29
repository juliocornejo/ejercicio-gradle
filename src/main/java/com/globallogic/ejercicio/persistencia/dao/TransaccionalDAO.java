package com.globallogic.ejercicio.persistencia.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.globallogic.ejercicio.persistencia.entity.Usuario;

/**
 * Created by julio cornejo on 29-07-19.
 */

@Repository
@Transactional
public class TransaccionalDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Usuario user) {
		entityManager.persist(user);
	}

	public Usuario buscar(String email) {

		try {

			Usuario usuario = entityManager.createQuery(
					"SELECT u from Usuario u WHERE u.email = :email", Usuario.class).

					setParameter("email", email).getSingleResult();

			return usuario;

		}catch(NoResultException e) {

		}
		return null;
	}
}
