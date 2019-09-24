package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.UnidadBusiness;
import com.hampcode.model.entity.Unidad;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class UnidadController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadBusiness unidadBusiness;

	private Unidad unidad;
	private List<Unidad> unidades;
	private Unidad unidadSelect;

	@PostConstruct
	public void init() {
		unidad = new Unidad();
		unidades = new ArrayList<Unidad>();
		unidadSelect = new Unidad();
		getAllUnidades();
	}

	public void getAllUnidades() {
		try {
			unidades = unidadBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Unidades:" + e.getMessage());
		}
	}

	public String newUnidad() {
		resetForm();
		return "insert_unidad.xhtml";
	}

	public String listUnidad() {
		return "list_unidad.xhtml";
	}

	public String saveUnidad() {
		String view = "";
		try {

			if (unidad.getIdUnidad() != null) {
				unidadBusiness.update(unidad);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				unidadBusiness.insert(unidad);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllUnidades();
			resetForm();
			view = "list_unidad";
		} catch (Exception e) {
			Message.messageError("Error Unidad :" + e.getStackTrace());
		}

		return view;
	}

	public String editUnidad() {
		String view = "";
		try {
			if (this.unidadSelect != null) {
				this.unidad = unidadSelect;

				view = "update_unidad";// Vista
			} else {
				Message.messageInfo("Debe seleccionar una unidad");
			}
		} catch (Exception e) {
			Message.messageError("Error unidad :" + e.getMessage());
		}

		return view;
	}

	public void selectUnidad(SelectEvent e) {
		this.unidadSelect = (Unidad) e.getObject();
	}

	public void resetForm() {
		this.unidad = new Unidad();
	}

	public UnidadBusiness getUnidadBusiness() {
		return unidadBusiness;
	}

	public void setUnidadBusiness(UnidadBusiness unidadBusiness) {
		this.unidadBusiness = unidadBusiness;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}

	public Unidad getUnidadSelect() {
		return unidadSelect;
	}

	public void setUnidadSelect(Unidad unidadSelect) {
		this.unidadSelect = unidadSelect;
	}
	
	
}
