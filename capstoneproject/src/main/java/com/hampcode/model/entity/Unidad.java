package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Unidad")
public class Unidad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cUnidad;
	
	@Column(name="NUnidad", nullable=false, length=50)
	private String nUnidad;

	public Long getcUnidad() {
		return cUnidad;
	}

	public void setcUnidad(Long cUnidad) {
		this.cUnidad = cUnidad;
	}

	public String getnUnidad() {
		return nUnidad;
	}

	public void setnUnidad(String nUnidad) {
		this.nUnidad = nUnidad;
	}
	
	
}
