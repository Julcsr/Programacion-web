package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long CProveedor;
	@Column(name="nproveedor", nullable=false,length=50)
	private String NProveedor;
	@Column(name="numtelefono_proveedor", nullable=false,length=50)
	private String NumTelefono_Proveedor;
	@Column(name="tdireccion_proveedor", nullable=false,length=50)
	private String TDireccion_Proveedor;
	
	
	public Long getCProveedor() {
		return CProveedor;
	}
	public void setCProveedor(Long cProveedor) {
		CProveedor = cProveedor;
	}
	public String getNProveedor() {
		return NProveedor;
	}
	public void setNProveedor(String nProveedor) {
		NProveedor = nProveedor;
	}
	public String getNumTelefono_Proveedor() {
		return NumTelefono_Proveedor;
	}
	public void setNumTelefono_Proveedor(String numTelefono_Proveedor) {
		NumTelefono_Proveedor = numTelefono_Proveedor;
	}
	public String getTDireccion_Proveedor() {
		return TDireccion_Proveedor;
	}
	public void setTDireccion_Proveedor(String tDireccion_Proveedor) {
		TDireccion_Proveedor = tDireccion_Proveedor;
	}
	
}
