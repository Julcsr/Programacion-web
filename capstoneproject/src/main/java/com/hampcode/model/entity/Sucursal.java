package com.hampcode.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sucursal")
public class Sucursal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long CSucursal;
	public Long getCSucursal() {
		return CSucursal;
	}
	public void setCSucursal(Long cSucursal) {
		CSucursal = cSucursal;
	}
	public char getNumTelefono_Sucursal() {
		return NumTelefono_Sucursal;
	}
	public void setNumTelefono_Sucursal(char numTelefono_Sucursal) {
		NumTelefono_Sucursal = numTelefono_Sucursal;
	}
	public char getTDireccion_Sucursal() {
		return TDireccion_Sucursal;
	}
	public void setTDireccion_Sucursal(char tDireccion_Sucursal) {
		TDireccion_Sucursal = tDireccion_Sucursal;
	}
	@Column(name="NumTelefono_Sucursal", nullable=false)
	private char NumTelefono_Sucursal;
	@Column(name="TDireccion_Sucursal", nullable=false)
	private char TDireccion_Sucursal;
	
}
