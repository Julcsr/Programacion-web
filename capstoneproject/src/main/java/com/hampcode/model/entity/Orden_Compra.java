package com.hampcode.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orden_Compra")

public class Orden_Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cOrden_Compra;

	@ManyToOne
	@JoinColumn(name="CProveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="CSucursal")
	private Sucursal sucursal;

	public Long getcOrden_Compra() {
		return cOrden_Compra;
	}

	public void setcOrden_Compra(Long cOrden_Compra) {
		this.cOrden_Compra = cOrden_Compra;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	
}
