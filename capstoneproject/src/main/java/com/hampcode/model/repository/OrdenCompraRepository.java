package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.OrdenCompra;

@Named
public class OrdenCompraRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long insert(OrdenCompra ordenCompra) throws Exception {
		em.persist(ordenCompra);
		return ordenCompra.getId();
	}

	public Long update(OrdenCompra ordenCompra) throws Exception {
		em.merge(ordenCompra);
		return ordenCompra.getId();
	}

	public void delete(OrdenCompra ordenCompra) throws Exception {
		em.remove(ordenCompra);
	}

	public List<OrdenCompra> findAll() throws Exception {
		List<OrdenCompra> ordenCompras = new ArrayList<>();

		TypedQuery<OrdenCompra> query = em.createQuery("FROM OrdenCompra i", OrdenCompra.class);
		ordenCompras = query.getResultList();

		return ordenCompras;
	}

	public List<OrdenCompra> findByName(String name) throws Exception {
		List<OrdenCompra> ordenCompras = new ArrayList<>();

		TypedQuery<OrdenCompra> query = em.createQuery("FROM OrdenCompra i WHERE i.descripcion LIKE ?1", OrdenCompra.class);
		query.setParameter(1, "%" + name + "%");
		ordenCompras = query.getResultList();

		return ordenCompras;
	}
}
