package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Direccion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idDireccion;
	@Column(name="referencia", nullable=false)
	String referencia;
	@Column(name="direccion", nullable=false)
	String direccion;
	@Column(name="cliente", nullable=false)
	Cliente cliente;
	@Column(name="tipoVivienda", nullable=false)
	TipoVivienda tipoVivienda;
	@Column(name="calle", nullable=false)
	Calle calle;

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoVivienda getTipoVivienda() {
		return tipoVivienda;
	}

	public void setTipoVivienda(TipoVivienda tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

}
