package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sabor")
public class Sabor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cSabor;
	
	@Column(name="NSabor", nullable=false, length=50)
	private String nSabor;

	public Long getcSabor() {
		return cSabor;
	}

	public void setcSabor(Long cSabor) {
		this.cSabor = cSabor;
	}

	public String getnSabor() {
		return nSabor;
	}

	public void setnSabor(String nSabor) {
		this.nSabor = nSabor;
	}
	
	
	
}
