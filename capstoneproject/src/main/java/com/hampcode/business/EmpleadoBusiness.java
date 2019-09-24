package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Empleado;
import com.hampcode.model.repository.EmpleadoRepository;

@Named
public class EmpleadoBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EmpleadoRepository empleadoRepository;

	@Transactional
	public Long insert(Empleado empleado) throws Exception {
		return empleadoRepository.insert(empleado);
	}

	@Transactional
	public Long update(Empleado empleado) throws Exception {
		return empleadoRepository.update(empleado);
	}

	public List<Empleado> getAll() throws Exception {
		return empleadoRepository.findAll();
	}

	public List<Empleado> getEmpleadosByName(String name) throws Exception {
		return empleadoRepository.findByName(name);
	}
}
