package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.MarcaBusiness;
import com.hampcode.model.entity.Marca;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class MarcaController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private MarcaBusiness marcaBusiness;

	private Marca marca;
	private List<Marca> marcas;
	private Marca marcaSelect;

	@PostConstruct
	public void init() {
		marca = new Marca();
		marcas = new ArrayList<Marca>();
		marcaSelect = new Marca();
		getAllMarcas();
	}

	public void getAllMarcas() {
		try {
			marcas = marcaBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de marcas:" + e.getMessage());
		}
	}

	public String newMarca() {
		resetForm();
		return "insert_marca.xhtml";
	}

	public String listMarca() {
		return "list_marca.xhtml";
	}

	public String saveMarca() {
		String view = "";
		try {

			if (marca.getIdMarca() != null) {
				marcaBusiness.update(marca);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				marcaBusiness.insert(marca);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllMarcas();
			resetForm();
			view = "list_marca";
		} catch (Exception e) {
			Message.messageError("Error marca :" + e.getStackTrace());
		}

		return view;
	}

	public String editMarca() {
		String view = "";
		try {
			if (this.marcaSelect != null) {
				this.marca = marcaSelect;

				view = "update_marca";// Vista
			} else {
				Message.messageInfo("Debe seleccionar una marca");
			}
		} catch (Exception e) {
			Message.messageError("Error marca :" + e.getMessage());
		}

		return view;
	}

	public void selectMarca(SelectEvent e) {
		this.marcaSelect = (Marca) e.getObject();
	}

	public void resetForm() {
		this.marca = new Marca();
	}

	public MarcaBusiness getMarcaBusiness() {
		return marcaBusiness;
	}

	public void setMarcaBusiness(MarcaBusiness marcaBusiness) {
		this.marcaBusiness = marcaBusiness;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca getMarcaSelect() {
		return marcaSelect;
	}

	public void setMarcaSelect(Marca marcaSelect) {
		this.marcaSelect = marcaSelect;
	}

}
