package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Proveedor")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long CProveedor;
	@Column(name="NProveedor", nullable=false)
	private char NProveedor;
	@Column(name="NumTelefono_Proveedor", nullable=false)
	private char NumTelefono_Proveedor;
	@Column(name="TDireccion_Proveedor", nullable=false)
	private char TDireccion_Proveedor;
	
	
	public Long getCProveedor() {
		return CProveedor;
	}
	public void setCProveedor(Long cProveedor) {
		CProveedor = cProveedor;
	}
	public char getNProveedor() {
		return NProveedor;
	}
	public void setNProveedor(char nProveedor) {
		NProveedor = nProveedor;
	}
	public char getNumTelefono_Proveedor() {
		return NumTelefono_Proveedor;
	}
	public void setNumTelefono_Proveedor(char numTelefono_Proveedor) {
		NumTelefono_Proveedor = numTelefono_Proveedor;
	}
	public char getTDireccion_Proveedor() {
		return TDireccion_Proveedor;
	}
	public void setTDireccion_Proveedor(char tDireccion_Proveedor) {
		TDireccion_Proveedor = tDireccion_Proveedor;
	}
	
}
