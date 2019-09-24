package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Sucursal;

@Named
public class SucursalRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public Long insert(Sucursal sucursal) throws Exception {
		em.persist(sucursal);
		return sucursal.getId();
	}

	public Long update(Sucursal sucursal) throws Exception {
		em.merge(sucursal);
		return sucursal.getId();
	}

	public void delete(Sucursal sucursal) throws Exception {
		em.remove(sucursal);
	}

	public List<Sucursal> findAll() throws Exception {
		List<Sucursal> sucursales = new ArrayList<>();

		TypedQuery<Sucursal> query = em.createQuery("FROM Sucursal s", Sucursal.class);
		sucursales = query.getResultList();

		return sucursales;
	}
}
