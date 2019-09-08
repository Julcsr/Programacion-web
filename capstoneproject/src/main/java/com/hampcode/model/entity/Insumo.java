package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Insumo")

public class Insumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cInsumo;

	@ManyToOne
	@JoinColumn(name="CSabor")
	private Sabor sabor;

	@ManyToOne
	@JoinColumn(name="CMarca")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name="CUnidad")
	private Unidad unidad;
	
	@Column(name = "NInsumo", nullable = false)
	private String nInsumo;

	@Column(name = "QPorcion_Insumo", nullable = true)
	private int cantidad_Porcion_Insumo;

	public Long getcInsumo() {
		return cInsumo;
	}

	public void setcInsumo(Long cInsumo) {
		this.cInsumo = cInsumo;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public String getnInsumo() {
		return nInsumo;
	}

	public void setnInsumo(String nInsumo) {
		this.nInsumo = nInsumo;
	}

	public int getCantidad_Porcion_Insumo() {
		return cantidad_Porcion_Insumo;
	}

	public void setCantidad_Porcion_Insumo(int cantidad_Porcion_Insumo) {
		this.cantidad_Porcion_Insumo = cantidad_Porcion_Insumo;
	}



}
