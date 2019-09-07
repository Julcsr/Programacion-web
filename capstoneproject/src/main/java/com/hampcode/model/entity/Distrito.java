package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Distrito")
public class Distrito {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idDistrito;
	@Column(name="nombreDistrito", nullable=false)
	String nombreDistrito;
	@Column(name="provincia", nullable=false)
	Provincia provincia;

	public Long getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public Provincia getIdProvincia() {
		return provincia;
	}

	public void setIdProvincia(Provincia idProvincia) {
		this.provincia = idProvincia;
	}

}
