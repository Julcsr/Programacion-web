package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Marca;
import com.hampcode.model.repository.MarcaRepository;

@Named
public class MarcaBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private MarcaRepository marcaRepository;

	@Transactional
	public Long insert(Marca marca) throws Exception {
		return marcaRepository.insert(marca);
	}

	@Transactional
	public Long update(Marca marca) throws Exception {
		return marcaRepository.update(marca);
	}

	public List<Marca> getAll() throws Exception {
		return marcaRepository.findAll();
	}
}
