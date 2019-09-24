package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.OrdenInsumo;
import com.hampcode.model.repository.OrdenInsumoRepository;

@Named
public class OrdenInsumoBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private OrdenInsumoRepository ordenInsumoRepository;

	@Transactional
	public Long insert(OrdenInsumo ordenInsumo) throws Exception {
		return ordenInsumoRepository.insert(ordenInsumo);
	}

	@Transactional
	public Long update(OrdenInsumo ordenInsumo) throws Exception {
		return ordenInsumoRepository.update(ordenInsumo);
	}

	public List<OrdenInsumo> getAll() throws Exception {
		return ordenInsumoRepository.findAll();
	}

	public List<OrdenInsumo> getOrdenInsumosByName(String name) throws Exception {
		return ordenInsumoRepository.findByName(name);
	}
}
