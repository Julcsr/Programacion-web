package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.TipoPedidoBusiness;
import com.hampcode.model.entity.TipoPedido;

import com.hampcode.util.Message;

@Named
@SessionScoped
public class TipoPedidoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private TipoPedidoBusiness tipoPedidoBusiness;

	private TipoPedido tipo;
	private List<TipoPedido> tipos;
	private TipoPedido tipoSelect;

	@PostConstruct
	public void init() {
		tipo = new TipoPedido();
		tipos = new ArrayList<TipoPedido>();
		tipoSelect = new TipoPedido();
		getAllTipos();
	}

	public void getAllTipos() {
		try {
			tipos = tipoPedidoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de tipos de pedido:" + e.getMessage());
		}
	}

	public String newTipo() {
		resetForm();
		return "insert_tipo.xhtml";
	}

	public String listTipo() {
		return "list_tipo.xhtml";
	}

	public String saveTipo() {
		String view = "";
		try {

			if (tipo.getId() != null) {
				tipoPedidoBusiness.update(tipo);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				tipoPedidoBusiness.insert(tipo);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllTipos();
			resetForm();
			view = "list_tipo";
		} catch (Exception e) {
			Message.messageError("Error tipo :" + e.getStackTrace());
		}

		return view;
	}

	public String editTipo() {
		String view = "";
		try {
			if (this.tipoSelect != null) {
				this.tipo = tipoSelect;

				view = "update_tipo";// Vista
			} else {
				Message.messageInfo("Debe seleccionar un tipo");
			}
		} catch (Exception e) {
			Message.messageError("Error tipo :" + e.getMessage());
		}

		return view;
	}

	public void selectTipo(SelectEvent e) {
		this.tipoSelect = (TipoPedido) e.getObject();
	}

	public void resetForm() {
		this.tipo = new TipoPedido();
	}

	public TipoPedidoBusiness getTipoPedidoBusiness() {
		return tipoPedidoBusiness;
	}

	public void setTipoPedidoBusiness(TipoPedidoBusiness tipoPedidoBusiness) {
		this.tipoPedidoBusiness = tipoPedidoBusiness;
	}

	public TipoPedido getTipo() {
		return tipo;
	}

	public void setTipo(TipoPedido tipo) {
		this.tipo = tipo;
	}

	public List<TipoPedido> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoPedido> tipos) {
		this.tipos = tipos;
	}

	public TipoPedido getTipoSelect() {
		return tipoSelect;
	}

	public void setTipoSelect(TipoPedido tipoSelect) {
		this.tipoSelect = tipoSelect;
	}

}
