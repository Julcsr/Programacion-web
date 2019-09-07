package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idEmpleado;
	@Column(name="nombreEmpleador", nullable=false)
	String nombreEmpleado;
	@Column(name="cargoEmpleado", nullable=false)
	CargoEmpleado cargoEmpleado;
	@Column(name="sucursal", nullable=false)
	Sucursal sucursal;

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public CargoEmpleado getCargo_empleado() {
		return cargoEmpleado;
	}

	public void setCargo_empleado(CargoEmpleado cargo_empleado) {
		this.cargoEmpleado = cargo_empleado;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}
