package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Empleado;

@Named
public class EmpleadoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public Long insert(Empleado empleado) throws Exception {
		em.persist(empleado);
		return empleado.getId();
	}

	public Long update(Empleado empleado) throws Exception {
		em.merge(empleado);
		return empleado.getId();
	}

	public void delete(Empleado empleado) throws Exception {
		em.remove(empleado);
	}

	public List<Empleado> findAll() throws Exception {
		List<Empleado> empleados = new ArrayList<>();

		TypedQuery<Empleado> query = em.createQuery("FROM Empleado i", Empleado.class);
		empleados = query.getResultList();

		return empleados;
	}

	public List<Empleado> findByName(String name) throws Exception {
		List<Empleado> empleados = new ArrayList<>();

		TypedQuery<Empleado> query = em.createQuery("FROM Empleado i WHERE i.nombre LIKE ?1", Empleado.class);
		query.setParameter(1, "%" + name + "%");
		empleados = query.getResultList();

		return empleados;
	}
}
