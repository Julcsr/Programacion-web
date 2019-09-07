package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Boleta")
public class Boleta extends Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idBoleta;
	@Column(name="tipoPago", nullable=false)
	int tipoPago;
	@Column(name="igv", nullable=false)
	float igv;
	@Column(name="comision", nullable=false)
	float comision;
	@Column(name="monto", nullable=false)
	float monto;

	public Long getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(Long idBoleta) {
		this.idBoleta = idBoleta;
	}

	public int getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(int tipoPago) {
		this.tipoPago = tipoPago;
	}

	public float getIgv() {
		return igv;
	}

	public void setIgv(float igv) {
		this.igv = igv;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

}
