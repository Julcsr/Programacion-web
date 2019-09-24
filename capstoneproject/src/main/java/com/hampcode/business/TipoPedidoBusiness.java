package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.TipoPedido;
import com.hampcode.model.repository.TipoPedidoRepository;

@Named
public class TipoPedidoBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private TipoPedidoRepository tipoPedidoRepository;

	@Transactional
	public Long insert(TipoPedido unidad) throws Exception {
		return tipoPedidoRepository.insert(unidad);
	}

	@Transactional
	public Long update(TipoPedido unidad) throws Exception {
		return tipoPedidoRepository.update(unidad);
	}

	public List<TipoPedido> getAll() throws Exception {
		return tipoPedidoRepository.findAll();
	}
}
