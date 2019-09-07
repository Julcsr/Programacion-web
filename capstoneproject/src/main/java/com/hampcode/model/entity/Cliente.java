package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idCliente;
	@Column(name="pnombreCliente", nullable=false)
	String pnombreCliente;
	@Column(name="snombreCLiente", nullable=false)
	String snombreCLiente;
	@Column(name="apellidoPaternoCliente", nullable=false)
	String apellidoPaternoCliente;
	@Column(name="apellidoMaternoCliente", nullable=false)
	String apellidoMaternoCliente;
	@Column(name="numTelefono", nullable=false)
	int numTelefono;
	@Column(name="dni", nullable=false)
	int dni;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getPnombreCliente() {
		return pnombreCliente;
	}

	public void setPnombreCliente(String pnombreCliente) {
		this.pnombreCliente = pnombreCliente;
	}

	public String getSnombreCLiente() {
		return snombreCLiente;
	}

	public void setSnombreCLiente(String snombreCLiente) {
		this.snombreCLiente = snombreCLiente;
	}

	public String getApellidoPaternoCliente() {
		return apellidoPaternoCliente;
	}

	public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
		this.apellidoPaternoCliente = apellidoPaternoCliente;
	}

	public String getApellidoMaternoCliente() {
		return apellidoMaternoCliente;
	}

	public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
		this.apellidoMaternoCliente = apellidoMaternoCliente;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

}
