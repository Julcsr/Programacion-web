package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Calle")
public class Calle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idCalle;
	@Column(name="nombreCalle", nullable=false)
	String nombreCalle;
	@Column(name="distrito", nullable=false)
	Distrito distrito;

	public Long getIdCalle() {
		return idCalle;
	}

	public void setIdCalle(Long idCalle) {
		this.idCalle = idCalle;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

}
