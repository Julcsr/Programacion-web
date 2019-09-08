package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ingrediente_Plato")

public class Ingrediente_Plato {

	@Id
	@ManyToOne
	@JoinColumn(name="CInsumo")
	private Insumo insumo;

	@Id
	@ManyToOne
	@JoinColumn(name="CProducto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="CUnidad")
	private Unidad unidad;
	
	@Column(name="NIngrediente_Plato", nullable=false, length=50)
	private String nIngrediente_Plato;
	
	@Column(name="MIngrediente_Plato", nullable=false, length=50)
	private String mIngrediente_Plato;

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public String getnIngrediente_Plato() {
		return nIngrediente_Plato;
	}

	public void setnIngrediente_Plato(String nIngrediente_Plato) {
		this.nIngrediente_Plato = nIngrediente_Plato;
	}

	public String getmIngrediente_Plato() {
		return mIngrediente_Plato;
	}

	public void setmIngrediente_Plato(String mIngrediente_Plato) {
		this.mIngrediente_Plato = mIngrediente_Plato;
	}
	
	
}
