package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Marca;

@Named
public class MarcaRepository implements Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long insert(Marca marca) throws Exception {
		em.persist(marca);
		return marca.getIdMarca();
	}

	public Long update(Marca marca) throws Exception {
		em.merge(marca); 
		return marca.getIdMarca();
	}

	public void delete(Marca marca) throws Exception {
		em.remove(marca);
	}

	public List<Marca> findAll() throws Exception {
		List<Marca> marcas = new ArrayList<>();

		TypedQuery<Marca> query = em.createQuery("FROM Marca m", Marca.class);
		marcas = query.getResultList();

		return marcas;
	}
}
