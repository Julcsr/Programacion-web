package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orden_Insumo")

public class Orden_Insumo {
	@Id
	@ManyToOne
	@JoinColumn(name="COrden_Insumo")
	private Orden_Insumo orden_Insumo;

	@Id
	@ManyToOne
	@JoinColumn(name="CInsumo")
	private Insumo insumo;
	
	@Column(name = "MCostoOrden", nullable = false)
	private double costoOrden;

	@Column(name = "QInsumos", nullable = false)
	private int cantidadInsumos;

	public Orden_Insumo getOrden_Insumo() {
		return orden_Insumo;
	}

	public void setOrden_Insumo(Orden_Insumo orden_Insumo) {
		this.orden_Insumo = orden_Insumo;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public double getCostoOrden() {
		return costoOrden;
	}

	public void setCostoOrden(double costoOrden) {
		this.costoOrden = costoOrden;
	}

	public int getCantidadInsumos() {
		return cantidadInsumos;
	}

	public void setCantidadInsumos(int cantidadInsumos) {
		this.cantidadInsumos = cantidadInsumos;
	}
	
	
	
}
