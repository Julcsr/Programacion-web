package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.OrdenInsumo;

@Named
public class OrdenInsumoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public Long insert(OrdenInsumo ordenInsumo) throws Exception {
		em.persist(ordenInsumo);
		return ordenInsumo.getId();
	}

	public Long update(OrdenInsumo ordenInsumo) throws Exception {
		em.merge(ordenInsumo);
		return ordenInsumo.getId();
	}

	public void delete(OrdenInsumo ordenInsumo) throws Exception {
		em.remove(ordenInsumo);
	}

	public List<OrdenInsumo> findAll() throws Exception {
		List<OrdenInsumo> ordenInsumos = new ArrayList<>();

		TypedQuery<OrdenInsumo> query = em.createQuery("FROM OrdenInsumo i", OrdenInsumo.class);
		ordenInsumos = query.getResultList();

		return ordenInsumos;
	}

	public List<OrdenInsumo> findByName(String name) throws Exception {
		List<OrdenInsumo> ordenInsumos = new ArrayList<>();

		TypedQuery<OrdenInsumo> query = em.createQuery("FROM OrdenInsumo i WHERE i.descripcion LIKE ?1",
				OrdenInsumo.class);
		query.setParameter(1, "%" + name + "%");
		ordenInsumos = query.getResultList();

		return ordenInsumos;
	}
}
