package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Delivery")
public class Delivery extends Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idDelivery;
	@Column(name="recepcionistaLlamadas", nullable=false)
	Empleado recepcionistaLlamadas;
	@Column(name="motorizado", nullable=false)
	Empleado motorizado;
	@Column(name="direccion", nullable=false)
	Direccion direccion;

	public Long getIdDelivery() {
		return idDelivery;
	}

	public void setIdDelivery(Long idDelivery) {
		this.idDelivery = idDelivery;
	}

	public Empleado getRecepcionistaLlamadas() {
		return recepcionistaLlamadas;
	}

	public void setRecepcionistaLlamadas(Empleado recepcionistaLlamadas) {
		this.recepcionistaLlamadas = recepcionistaLlamadas;
	}

	public Empleado getMotorizado() {
		return motorizado;
	}

	public void setMotorizado(Empleado motorizado) {
		this.motorizado = motorizado;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
