package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Marca")
public class Marca {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cMarca;
	
	@Column(name="NMarca", nullable=false, length=50)
	private String nMarca;

	public Long getcMarca() {
		return cMarca;
	}

	public void setcMarca(Long cMarca) {
		this.cMarca = cMarca;
	}

	public String getnMarca() {
		return nMarca;
	}

	public void setnMarca(String nMarca) {
		this.nMarca = nMarca;
	}
	
	
}


