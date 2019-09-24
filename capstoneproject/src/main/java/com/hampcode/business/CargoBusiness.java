package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Cargo;
import com.hampcode.model.repository.CargoRepository;

@Named
public class CargoBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CargoRepository cargoRepository;

	@Transactional
	public Long insert(Cargo empleado) throws Exception {
		return cargoRepository.insert(empleado);
	}

	@Transactional
	public Long update(Cargo empleado) throws Exception {
		return cargoRepository.update(empleado);
	}

	public List<Cargo> getAll() throws Exception {
		return cargoRepository.findAll();
	}
}
