package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.OrdenCompra;
import com.hampcode.model.repository.OrdenCompraRepository;

@Named
public class OrdenCompraBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrdenCompraRepository ordenCompraRepository;

	@Transactional
	public Long insert(OrdenCompra ordenCompra) throws Exception {
		return ordenCompraRepository.insert(ordenCompra);
	}

	@Transactional
	public Long update(OrdenCompra ordenCompra) throws Exception {
		return ordenCompraRepository.update(ordenCompra);
	}

	public List<OrdenCompra> getAll() throws Exception {
		return ordenCompraRepository.findAll();
	}

	public List<OrdenCompra> getOrdenComprasByName(String name) throws Exception {
		return ordenCompraRepository.findByName(name);
	}
}
