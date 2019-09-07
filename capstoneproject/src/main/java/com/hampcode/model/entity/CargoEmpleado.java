package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CargoEmpleado")
public class CargoEmpleado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long CCargo;
	@Column(name="NCargo", nullable=false)
	String NCargo;

	public Long getCCargo() {
		return CCargo;
	}

	public void setCCargo(Long cCargo) {
		CCargo = cCargo;
	}

	public String getNCargo() {
		return NCargo;
	}

	public void setNCargo(String nCargo) {
		NCargo = nCargo;
		///:v
	}

}
