package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Local")
public class Local {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idLocal;
	@Column(name="mozo", nullable=false)
	Empleado mozo;

	public Long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(Long idLocal) {
		this.idLocal = idLocal;
	}

	public Empleado getMozo() {
		return mozo;
	}

	public void setMozo(Empleado mozo) {
		this.mozo = mozo;
	}

}
