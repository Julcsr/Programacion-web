package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Insumo;

import com.hampcode.model.repository.InsumoRepository;

@Named
public class InsumoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private InsumoRepository insumoRepository;

	@Transactional
	public Long insert(Insumo insumo) throws Exception {
		return insumoRepository.insert(insumo);
	}

	@Transactional
	public Long update(Insumo insumo) throws Exception {
		return insumoRepository.update(insumo);
	}

	public List<Insumo> getAll() throws Exception {
		return insumoRepository.findAll();
	}

	public List<Insumo> getInsumosByName(String name) throws Exception {
		return insumoRepository.findByName(name);
	}
}
