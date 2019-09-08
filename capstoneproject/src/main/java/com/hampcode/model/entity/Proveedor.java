package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cProveedor;
	
	@Column(name="nProducto", nullable=false, length=50)
	private String nProducto;

	public Long getcProveedor() {
		return cProveedor;
	}

	public void setcProveedor(Long cProveedor) {
		this.cProveedor = cProveedor;
	}

	public String getnProducto() {
		return nProducto;
	}

	public void setnProducto(String nProducto) {
		this.nProducto = nProducto;
	}
	
	
	
}
