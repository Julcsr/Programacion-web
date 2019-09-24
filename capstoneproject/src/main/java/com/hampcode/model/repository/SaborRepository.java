package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Sabor;

@Named
public class SaborRepository implements Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long insert(Sabor sabor) throws Exception {
		em.persist(sabor);
		return sabor.getIdSabor();
	}

	public Long update(Sabor sabor) throws Exception {
		em.merge(sabor); 
		return sabor.getIdSabor();
	}

	public void delete(Sabor sabor) throws Exception {
		em.remove(sabor);
	}

	public List<Sabor> findAll() throws Exception {
		List<Sabor> sabores = new ArrayList<>();

		TypedQuery<Sabor> query = em.createQuery("FROM Sabor s", Sabor.class);
		sabores = query.getResultList();

		return sabores;
	}
}
