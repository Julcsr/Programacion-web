package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Unidad;

@Named
public class UnidadRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long insert(Unidad unidad) throws Exception {
		em.persist(unidad);
		return unidad.getIdUnidad();
	}

	public Long update(Unidad unidad) throws Exception {
		em.merge(unidad); 
		return unidad.getIdUnidad();
	}

	public void delete(Unidad unidad) throws Exception {
		em.remove(unidad);
	}

	public List<Unidad> findAll() throws Exception {
		List<Unidad> unidades = new ArrayList<>();

		TypedQuery<Unidad> query = em.createQuery("FROM Unidad i", Unidad.class);
		unidades = query.getResultList();

		return unidades;
	}
}
