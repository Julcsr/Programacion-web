package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.TipoPedido;

@Named
public class TipoPedidoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long insert(TipoPedido tipo) throws Exception {
		em.persist(tipo);
		return tipo.getId();
	}

	public Long update(TipoPedido tipo) throws Exception {
		em.merge(tipo); 
		return tipo.getId();
	}

	public void delete(TipoPedido tipo) throws Exception {
		em.remove(tipo);
	}

	public List<TipoPedido> findAll() throws Exception {
		List<TipoPedido> tipos = new ArrayList<>();

		TypedQuery<TipoPedido> query = em.createQuery("FROM TipoPedido i", TipoPedido.class);
		tipos = query.getResultList();

		return tipos;
	}
}
