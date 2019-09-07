package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoPedido")
public class TipoPedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idTipoPedido;
	@Column(name="nombreTipoPedido", nullable=false)
	String nombreTipoPedido;

	public Long getIdTipoPedido() {
		return idTipoPedido;
	}

	public void setIdTipoPedido(Long idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}

	public String getNombreTipoPedido() {
		return nombreTipoPedido;
	}

	public void setNombreTipoPedido(String nombreTipoPedido) {
		this.nombreTipoPedido = nombreTipoPedido;
	}

}
