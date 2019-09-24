package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.CargoBusiness;
import com.hampcode.model.entity.Cargo;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class CargoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CargoBusiness cargoBusiness;

	private Cargo cargo;
	private List<Cargo> cargos;
	private Cargo cargoSelect;

	@PostConstruct
	public void init() {
		cargo = new Cargo();
		cargos = new ArrayList<Cargo>();
		cargoSelect = new Cargo();
		getAllCargos();
	}

	public void getAllCargos() {
		try {
			cargos = cargoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de cargos:" + e.getMessage());
		}
	}

	public String newCargo() {
		resetForm();
		return "insert_cargo.xhtml";
	}

	public String listCargo() {
		return "list_cargo.xhtml";
	}

	public String saveCargo() {
		String view = "";
		try {

			if (cargo.getId() != null) {
				cargoBusiness.update(cargo);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				cargoBusiness.insert(cargo);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllCargos();
			resetForm();
			view = "list_cargo";
		} catch (Exception e) {
			Message.messageError("Error cargo :" + e.getStackTrace());
		}

		return view;
	}

	public String editCargo() {
		String view = "";
		try {
			if (this.cargoSelect != null) {
				this.cargo = cargoSelect;

				view = "update_cargo";// Vista
			} else {
				Message.messageInfo("Debe seleccionar una cargo");
			}
		} catch (Exception e) {
			Message.messageError("Error cargo :" + e.getMessage());
		}

		return view;
	}

	public void selectCargo(SelectEvent e) {
		this.cargoSelect = (Cargo) e.getObject();
	}

	public void resetForm() {
		this.cargo = new Cargo();
	}

	public CargoBusiness getCargoBusiness() {
		return cargoBusiness;
	}

	public void setCargoBusiness(CargoBusiness cargoBusiness) {
		this.cargoBusiness = cargoBusiness;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo getCargoSelect() {
		return cargoSelect;
	}

	public void setCargoSelect(Cargo cargoSelect) {
		this.cargoSelect = cargoSelect;
	}

}
