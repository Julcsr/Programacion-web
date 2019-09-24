package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.SucursalBusiness;
import com.hampcode.model.entity.Sucursal;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class SucursalController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private SucursalBusiness sucursalBusiness;

	private Sucursal sucursal;
	private List<Sucursal> sucursales;
	private Sucursal sucursalSelect;

	@PostConstruct
	public void init() {
		sucursal = new Sucursal();
		sucursales = new ArrayList<Sucursal>();
		sucursalSelect = new Sucursal();
		getAllSucursales();
	}

	public void getAllSucursales() {
		try {
			sucursales = sucursalBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de sucursales:" + e.getMessage());
		}
	}

	public String newSucursal() {
		resetForm();
		return "insert_sucursal.xhtml";
	}

	public String listSucursal() {
		return "list_sucursal.xhtml";
	}

	public String saveSucursal() {
		String view = "";
		try {

			if (sucursal.getId() != null) {
				sucursalBusiness.update(sucursal);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				sucursalBusiness.insert(sucursal);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllSucursales();
			resetForm();
			view = "list_sucursal";
		} catch (Exception e) {
			Message.messageError("Error sucursal :" + e.getStackTrace());
		}

		return view;
	}

	public String editSucursal() {
		String view = "";
		try {
			if (this.sucursalSelect != null) {
				this.sucursal = sucursalSelect;

				view = "update_sucursal";// Vista
			} else {
				Message.messageInfo("Debe seleccionar una sucursal");
			}
		} catch (Exception e) {
			Message.messageError("Error sucursal :" + e.getMessage());
		}

		return view;
	}

	public void selectSucursal(SelectEvent e) {
		this.sucursalSelect = (Sucursal) e.getObject();
	}

	public void resetForm() {
		this.sucursal = new Sucursal();
	}

	public SucursalBusiness getSucursalBusiness() {
		return sucursalBusiness;
	}

	public void setSucursalBusiness(SucursalBusiness sucursalBusiness) {
		this.sucursalBusiness = sucursalBusiness;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public Sucursal getSucursalSelect() {
		return sucursalSelect;
	}

	public void setSucursalSelect(Sucursal sucursalSelect) {
		this.sucursalSelect = sucursalSelect;
	}

}
