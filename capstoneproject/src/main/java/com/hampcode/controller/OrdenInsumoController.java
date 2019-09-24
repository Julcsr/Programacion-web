package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.InsumoBusiness;
import com.hampcode.business.OrdenCompraBusiness;
import com.hampcode.business.OrdenInsumoBusiness;
import com.hampcode.model.entity.Insumo;
import com.hampcode.model.entity.OrdenCompra;
import com.hampcode.model.entity.OrdenInsumo;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class OrdenInsumoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private OrdenInsumoBusiness ordenInsumoBusiness;

	@Inject
	private OrdenCompraBusiness ordenCompraBusiness;

	@Inject
	private InsumoBusiness insumoBusiness;

	private OrdenInsumo ordenInsumo;
	private List<OrdenInsumo> ordenInsumos;
	private OrdenInsumo ordenInsumoSelect;

	private OrdenCompra ordenCompra;
	private List<OrdenCompra> ordenCompras;

	private Insumo insumo;
	private List<Insumo> insumos;

	private String filterName;

	@PostConstruct
	public void init() {
		ordenInsumo = new OrdenInsumo();
		ordenInsumos = new ArrayList<OrdenInsumo>();
		ordenInsumoSelect = new OrdenInsumo();

		insumo = new Insumo();
		insumos = new ArrayList<Insumo>();

		ordenCompra = new OrdenCompra();
		ordenCompras = new ArrayList<OrdenCompra>();

		getAllOrdenInsumos();
	}

	public void getAllOrdenInsumos() {
		try {
			ordenInsumos = ordenInsumoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Ordenes :" + e.getMessage());
		}
	}

	public String newOrdenInsumo() {
		try {
			this.insumos = insumoBusiness.getAll();
			this.ordenCompras = ordenCompraBusiness.getAll();
			resetForm();
		} catch (Exception e) {

		}

		return "insert_orden_insumos.xhtml";
	}

	public String listOrdenInsumos() {
		return "list_orden_insumos.xhtml";
	}

	public String saveOrdenInsumo() {
		String view = "";
		try {
			if (ordenInsumo.getId() != null) {
				ordenInsumo.setInsumo(insumo);
				ordenInsumo.setOrdenCompra(ordenCompra);
				ordenInsumoBusiness.update(ordenInsumo);
				insumo.setStock(insumo.getStock()+ordenInsumo.getCantidad());
				insumoBusiness.update(insumo);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				ordenInsumo.setInsumo(insumo);
				ordenInsumo.setOrdenCompra(ordenCompra);
				ordenInsumoBusiness.insert(ordenInsumo);
				insumo.setStock(insumo.getStock()+ordenInsumo.getCantidad());
				insumoBusiness.update(insumo);
				Message.messageInfo("Registro guardado exitosamente");
			}
			this.getAllOrdenInsumos();
			resetForm();
			view = "list_orden_insumos";
		} catch (Exception e) {
			Message.messageError("Error Orden :" + e.getStackTrace());
		}

		return view;
	}

	public String editOrdenInsumos() {
		String view = "";
		try {
			if (this.ordenInsumoSelect != null) {
				this.ordenInsumo = ordenInsumoSelect;

				view = "update_orden_insumos";// Vista
			} else {
				Message.messageInfo("Debe seleccionar una orden");
			}
		} catch (Exception e) {
			Message.messageError("Error orden :" + e.getMessage());
		}

		return view;
	}

	public void searchOrdenInsumoByName() {
		try {

			ordenInsumos = ordenInsumoBusiness.getOrdenInsumosByName(this.filterName.trim());
			resetForm();
			if (ordenInsumos.isEmpty()) {
				Message.messageInfo("No se encontraron ordenes");

			}

		} catch (Exception e) {
			Message.messageError("Error orden Search :" + e.getMessage());
		}
	}

	public void selectOrdenInsumo(SelectEvent e) {
		this.ordenInsumoSelect = (OrdenInsumo) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.ordenInsumo = new OrdenInsumo();
	}

	public OrdenInsumoBusiness getOrdenInsumoBusiness() {
		return ordenInsumoBusiness;
	}

	public void setOrdenInsumoBusiness(OrdenInsumoBusiness ordenInsumoBusiness) {
		this.ordenInsumoBusiness = ordenInsumoBusiness;
	}

	public OrdenCompraBusiness getOrdenCompraBusiness() {
		return ordenCompraBusiness;
	}

	public void setOrdenCompraBusiness(OrdenCompraBusiness ordenCompraBusiness) {
		this.ordenCompraBusiness = ordenCompraBusiness;
	}

	public InsumoBusiness getInsumoBusiness() {
		return insumoBusiness;
	}

	public void setInsumoBusiness(InsumoBusiness insumoBusiness) {
		this.insumoBusiness = insumoBusiness;
	}

	public OrdenInsumo getOrdenInsumo() {
		return ordenInsumo;
	}

	public void setOrdenInsumo(OrdenInsumo ordenInsumo) {
		this.ordenInsumo = ordenInsumo;
	}

	public List<OrdenInsumo> getOrdenInsumos() {
		return ordenInsumos;
	}

	public void setOrdenInsumos(List<OrdenInsumo> ordenInsumos) {
		this.ordenInsumos = ordenInsumos;
	}

	public OrdenInsumo getOrdenInsumoSelect() {
		return ordenInsumoSelect;
	}

	public void setOrdenInsumoSelect(OrdenInsumo ordenInsumoSelect) {
		this.ordenInsumoSelect = ordenInsumoSelect;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public List<OrdenCompra> getOrdenCompras() {
		return ordenCompras;
	}

	public void setOrdenCompras(List<OrdenCompra> ordenCompras) {
		this.ordenCompras = ordenCompras;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public List<Insumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
