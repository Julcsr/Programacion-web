package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cProducto;
	
	@Column(name="NProducto", nullable=false, length=50)
	private String nProducto;
	
	@Column(name="MPrecio", nullable=false, length=50)
	private String mPrecio;

	public Long getcProducto() {
		return cProducto;
	}

	public void setcProducto(Long cProducto) {
		this.cProducto = cProducto;
	}

	public String getnProducto() {
		return nProducto;
	}

	public void setnProducto(String nProducto) {
		this.nProducto = nProducto;
	}

	public String getmPrecio() {
		return mPrecio;
	}

	public void setmPrecio(String mPrecio) {
		this.mPrecio = mPrecio;
	}
	
	
	
}
