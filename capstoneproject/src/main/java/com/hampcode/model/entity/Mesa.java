package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mesa")
public class Mesa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idMesa;
	@Column(name="numAsientos", nullable=false)
	int numAsientos;
	@Column(name="sucursal", nullable=false)
	Sucursal sucursal;
	@Column(name="pLocal", nullable=false)
	Local pLocal;

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Local getpLocal() {
		return pLocal;
	}

	public void setpLocal(Local pLocal) {
		this.pLocal = pLocal;
	}

}
