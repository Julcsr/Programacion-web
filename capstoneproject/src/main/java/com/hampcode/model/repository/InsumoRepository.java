package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Insumo;

@Named
public class InsumoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public Long insert(Insumo insumo) throws Exception {
		em.persist(insumo);
		return insumo.getIdInsumo();
	}

	public Long update(Insumo insumo) throws Exception {
		em.merge(insumo);
		return insumo.getIdInsumo();
	}

	public void delete(Insumo insumo) throws Exception {
		em.remove(insumo);
	}

	public List<Insumo> findAll() throws Exception {
		List<Insumo> insumos = new ArrayList<>();

		TypedQuery<Insumo> query = em.createQuery("FROM Insumo i", Insumo.class);
		insumos = query.getResultList();

		return insumos;
	}

	public Optional<Insumo> findById(Long id) throws Exception {
		Insumo insumoFound;

		TypedQuery<Insumo> query = em.createQuery("FROM Insumo i WHERE i.idInsumo=?1", Insumo.class);

		query.setParameter(1, id);
		insumoFound = query.getSingleResult();

		return Optional.of(insumoFound);
	}

	public List<Insumo> findByName(String name) throws Exception {
		List<Insumo> insumos = new ArrayList<>();

		TypedQuery<Insumo> query = em.createQuery("FROM Insumo i WHERE i.nombreInsumo LIKE ?1", Insumo.class);
		query.setParameter(1, "%" + name + "%");
		insumos = query.getResultList();

		return insumos;
	}
}
