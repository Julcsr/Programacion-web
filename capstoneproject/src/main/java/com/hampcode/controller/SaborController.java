package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.SaborBusiness;
import com.hampcode.model.entity.Sabor;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class SaborController implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private SaborBusiness saborBusiness;

	private Sabor sabor;
	private List<Sabor> sabores;
	private Sabor saborSelect;

	@PostConstruct
	public void init() {
		sabor = new Sabor();
		sabores = new ArrayList<Sabor>();
		saborSelect = new Sabor();
		getAllSabores();
	}

	public void getAllSabores() {
		try {
			sabores = saborBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de sabores:" + e.getMessage());
		}
	}

	public String newSabor() {
		resetForm();
		return "insert_sabor.xhtml";
	}

	public String listSabor() {
		return "list_sabor.xhtml";
	}

	public String saveSabor() {
		String view = "";
		try {

			if (sabor.getIdSabor() != null) {
				saborBusiness.update(sabor);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				saborBusiness.insert(sabor);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllSabores();
			resetForm();
			view = "list_sabor";
		} catch (Exception e) {
			Message.messageError("Error sabor :" + e.getStackTrace());
		}

		return view;
	}

	public String editSabor() {
		String view = "";
		try {
			if (this.saborSelect != null) {
				this.sabor = saborSelect;

				view = "update_sabor";// Vista
			} else {
				Message.messageInfo("Debe seleccionar una sabor");
			}
		} catch (Exception e) {
			Message.messageError("Error sabor :" + e.getMessage());
		}

		return view;
	}

	public void selectSabor(SelectEvent e) {
		this.saborSelect = (Sabor) e.getObject();
	}

	public void resetForm() {
		this.sabor = new Sabor();
	}

	public SaborBusiness getSaborBusiness() {
		return saborBusiness;
	}

	public void setSaborBusiness(SaborBusiness saborBusiness) {
		this.saborBusiness = saborBusiness;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public List<Sabor> getSabores() {
		return sabores;
	}

	public void setSabores(List<Sabor> sabores) {
		this.sabores = sabores;
	}

	public Sabor getSaborSelect() {
		return saborSelect;
	}

	public void setSaborSelect(Sabor saborSelect) {
		this.saborSelect = saborSelect;
	}
	
	

}
