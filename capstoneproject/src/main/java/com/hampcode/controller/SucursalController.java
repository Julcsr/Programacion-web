package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.SucursalBusiness;
import com.hampcode.model.entity.Sucursal;
import com.hampcode.util.Message;

public class SucursalController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SucursalBusiness sucursalBusiness;

	private Sucursal sucursal; //NuevoSucursalo
	private List<Sucursal> sucursals;//ListaSucursalos
	private Sucursal sucursalSelect;//Sucursalo Seleccionado Editar
	private String filterName;// Criterio de Busqueda

	@PostConstruct
	public void init() {
		sucursal = new Sucursal();
		sucursals = new ArrayList<Sucursal>();
		getAllSucursals();
	}

	public void getAllSucursals() {
		try {
			sucursals = sucursalBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Sucursalos :" + e.getMessage());
		}
	}

	public String newSucursal() {
		resetForm();
		return "insert.xhtml";
	}

	public String listSucursal() {
		return "list.xhtml";
	}

	public String saveSucursal() {
		String view = "";
		try {

			if (sucursal.getCSucursal()!=null) {
				sucursalBusiness.update(sucursal);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				sucursalBusiness.insert(sucursal);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllSucursals();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Sucursal :" + e.getStackTrace());
		}

		return view;
	}

	public String editSucursal() {
		String view = "";
		try {
			if (this.sucursalSelect != null) {
				this.sucursal = sucursalSelect;

				view = "update";// Vista
			} else {
				Message.messageInfo("Debe seleccionar un proveedor");
			}
		} catch (Exception e) {
			Message.messageError("Error Sucursal :" + e.getMessage());
		}

		return view;
	}

	public void searchSucursalByName() {
		try {

			sucursals = sucursalBusiness.getSucursalsByName(this.filterName.trim());
			resetForm();
			if (sucursals.isEmpty()) {
				Message.messageInfo("No se encontraron sucursalos");

			}

		} catch (Exception e) {
			Message.messageError("Error Sucursal Search :" + e.getMessage());
		}
	}

	public void selectSucursal(SelectEvent e) {
		this.sucursalSelect = (Sucursal) e.getObject();
	}

	public void resetForm() {
		this.filterName="";
		this.sucursal = new Sucursal();
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Sucursal> getSucursals() {
		return sucursals;
	}

	public void setSucursals(List<Sucursal> sucursals) {
		this.sucursals = sucursals;
	}

	public Sucursal getSucursalSelect() {
		return sucursalSelect;
	}

	public void setSucursalSelect(Sucursal sucursalSelect) {
		this.sucursalSelect = sucursalSelect;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}