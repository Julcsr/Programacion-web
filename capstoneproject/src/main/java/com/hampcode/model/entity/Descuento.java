package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Descuento")
public class Descuento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idDescuento;
	@Column(name="porcentajeDescuento", nullable=false)
	float porcentajeDescuento;
	@Column(name="diaInicio", nullable=false)
	String diaInicio;
	@Column(name="diaFin", nullable=false)
	String diaFin;

	public Long getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(Long idDescuento) {
		this.idDescuento = idDescuento;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public String getDiaInicio() {
		return diaInicio;
	}

	public void setDiaInicio(String diaInicio) {
		this.diaInicio = diaInicio;
	}

	public String getDiaFin() {
		return diaFin;
	}

	public void setDiaFin(String diaFin) {
		this.diaFin = diaFin;
	}

}
