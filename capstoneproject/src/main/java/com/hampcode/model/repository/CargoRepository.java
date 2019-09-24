package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Cargo;

@Named
public class CargoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public Long insert(Cargo cempleado) throws Exception {
		em.persist(cempleado);
		return cempleado.getId();
	}

	public Long update(Cargo empleado) throws Exception {
		em.merge(empleado);
		return empleado.getId();
	}

	public void delete(Cargo empleado) throws Exception {
		em.remove(empleado);
	}

	public List<Cargo> findAll() throws Exception {
		List<Cargo> empleados = new ArrayList<>();

		TypedQuery<Cargo> query = em.createQuery("FROM Cargo i", Cargo.class);
		empleados = query.getResultList();

		return empleados;
	}
}
