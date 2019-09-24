package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sabores")
public class Sabor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idSabor;
	@Column(name = "nombre_sabor", nullable = false, length=50)
	String nombreSabor;

	public Long getIdSabor() {
		return idSabor;
	}

	public void setIdSabor(Long idSabor) {
		this.idSabor = idSabor;
	}

	public String getNombreSabor() {
		return nombreSabor;
	}

	public void setNombreSabor(String nombreSabor) {
		this.nombreSabor = nombreSabor;
	}

}
