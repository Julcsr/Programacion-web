package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orden_Insumo")

public class Categoria_Comida {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cSubCategoria;
	
	@Column(name="NCategoria", nullable=false, length=50)
	private String nCategoria;
	
	@Column(name="CCategoria", nullable=true, length=50)
	private Categoria_Comida cCategoria;

	public Long getcSubCategoria() {
		return cSubCategoria;
	}

	public void setcSubCategoria(Long cSubCategoria) {
		this.cSubCategoria = cSubCategoria;
	}

	public String getnCategoria() {
		return nCategoria;
	}

	public void setnCategoria(String nCategoria) {
		this.nCategoria = nCategoria;
	}

	public Categoria_Comida getcCategoria() {
		return cCategoria;
	}

	public void setcCategoria(Categoria_Comida cCategoria) {
		this.cCategoria = cCategoria;
	}
	
	
	
}
