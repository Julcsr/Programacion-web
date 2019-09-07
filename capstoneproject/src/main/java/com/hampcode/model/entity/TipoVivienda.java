package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoVivienda")
public class TipoVivienda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idTipoVivienda;
	@Column(name="nombreTipoVivienda", nullable=false)
	String nombreTipoVivienda;

	public Long getIdTipoVivienda() {
		return idTipoVivienda;
	}

	public void setIdTipoVivienda(Long idTipoVivienda) {
		this.idTipoVivienda = idTipoVivienda;
	}

	public String getNombreTipoVivienda() {
		return nombreTipoVivienda;
	}

	public void setNombreTipoVivienda(String nombreTipoVivienda) {
		this.nombreTipoVivienda = nombreTipoVivienda;
	}

}
