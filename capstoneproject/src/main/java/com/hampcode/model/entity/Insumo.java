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
@Table(name = "insumos")
public class Insumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInsumo;
	@Column(name = "nombre_insumo", nullable = false, length = 50)
	private String nombreInsumo;
	@ManyToOne
	@JoinColumn(name = "id_unidad")
	private Unidad unidadInsumo;
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marcaInsumo;
	@ManyToOne
	@JoinColumn(name = "id_sabor")
	private Sabor saborInsumo;

	private int porcion;

	private int stock;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(Long idInsumo) {
		this.idInsumo = idInsumo;
	}

	public String getNombreInsumo() {
		return nombreInsumo;
	}

	public void setNombreInsumo(String nombreInsumo) {
		this.nombreInsumo = nombreInsumo;
	}

	public Unidad getUnidadInsumo() {
		return unidadInsumo;
	}

	public void setUnidadInsumo(Unidad unidadInsumo) {
		this.unidadInsumo = unidadInsumo;
	}

	public Marca getMarcaInsumo() {
		return marcaInsumo;
	}

	public void setMarcaInsumo(Marca marcaInsumo) {
		this.marcaInsumo = marcaInsumo;
	}

	public Sabor getSaborInsumo() {
		return saborInsumo;
	}

	public void setSaborInsumo(Sabor saborInsumo) {
		this.saborInsumo = saborInsumo;
	}

	public int getPorcion() {
		return porcion;
	}

	public void setPorcion(int porcion) {
		this.porcion = porcion;
	}

}
