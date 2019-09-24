package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Unidad;
import com.hampcode.model.repository.UnidadRepository;

@Named
public class UnidadBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadRepository unidadRepository;

	@Transactional
	public Long insert(Unidad unidad) throws Exception {
		return unidadRepository.insert(unidad);
	}

	@Transactional
	public Long update(Unidad unidad) throws Exception {
		return unidadRepository.update(unidad);
	}

	public List<Unidad> getAll() throws Exception {
		return unidadRepository.findAll();
	}
}
