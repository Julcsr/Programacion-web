package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.OrdenCompraBusiness;
import com.hampcode.business.SucursalBusiness;
import com.hampcode.business.SupplierBusiness;

import com.hampcode.model.entity.OrdenCompra;
import com.hampcode.model.entity.Sucursal;
import com.hampcode.model.entity.Supplier;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class OrdenCompraController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private OrdenCompraBusiness ordenCompraBusiness;

	@Inject
	private SupplierBusiness supplierBusiness;

	@Inject
	private SucursalBusiness sucursalBusiness;

	private OrdenCompra ordenCompra;
	private List<OrdenCompra> ordenCompras;
	private OrdenCompra ordenCompraSelect;

	private Supplier supplier;
	private List<Supplier> suppliers;

	private Sucursal sucursal;
	private List<Sucursal> sucursales;

	private String filterName;

	@PostConstruct
	public void init() {
		ordenCompra = new OrdenCompra();
		ordenCompras = new ArrayList<OrdenCompra>();
		ordenCompraSelect = new OrdenCompra();

		supplier = new Supplier();
		suppliers = new ArrayList<Supplier>();

		sucursal = new Sucursal();
		sucursales = new ArrayList<Sucursal>();

		getAllOrdenCompras();
	}

	public void getAllOrdenCompras() {
		try {
			ordenCompras = ordenCompraBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Ordenes :" + e.getMessage());
		}
	}

	public String newOrdenCompra() {
		try {
			this.suppliers = supplierBusiness.getAll();
			this.sucursales = sucursalBusiness.getAll();
			resetForm();
		} catch (Exception e) {

		}

		return "insert_orden_compras.xhtml";
	}

	public String listOrdenCompras() {
		return "list_orden_compras.xhtml";
	}

	public String saveOrdenCompra() {
		String view = "";
		try {

			if (ordenCompra.getId() != null) {

				ordenCompra.setSucursal(sucursal);
				ordenCompra.setSupplier(supplier);
				ordenCompraBusiness.update(ordenCompra);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				ordenCompra.setSucursal(sucursal);
				ordenCompra.setSupplier(supplier);
				ordenCompraBusiness.insert(ordenCompra);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllOrdenCompras();
			resetForm();
			view = "list_orden_compras";
		} catch (Exception e) {
			Message.messageError("Error Orden :" + e.getStackTrace());
		}

		return view;
	}

	public String editOrdenCompras() {
		String view = "";
		try {
			if (this.ordenCompraSelect != null) {
				this.ordenCompra = ordenCompraSelect;

				view = "update_orden_compras";// Vista
			} else {
				Message.messageInfo("Debe seleccionar una orden");
			}
		} catch (Exception e) {
			Message.messageError("Error orden :" + e.getMessage());
		}

		return view;
	}

	public void searchOrdenCompraByName() {
		try {

			ordenCompras = ordenCompraBusiness.getOrdenComprasByName(this.filterName.trim());
			resetForm();
			if (ordenCompras.isEmpty()) {
				Message.messageInfo("No se encontraron ordenes");

			}

		} catch (Exception e) {
			Message.messageError("Error orden Search :" + e.getMessage());
		}
	}

	public void selectOrdenCompra(SelectEvent e) {
		this.ordenCompraSelect = (OrdenCompra) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.ordenCompra = new OrdenCompra();
	}

	public OrdenCompraBusiness getOrdenCompraBusiness() {
		return ordenCompraBusiness;
	}

	public void setOrdenCompraBusiness(OrdenCompraBusiness ordenCompraBusiness) {
		this.ordenCompraBusiness = ordenCompraBusiness;
	}

	public SupplierBusiness getSupplierBusiness() {
		return supplierBusiness;
	}

	public void setSupplierBusiness(SupplierBusiness supplierBusiness) {
		this.supplierBusiness = supplierBusiness;
	}

	public SucursalBusiness getSucursalBusiness() {
		return sucursalBusiness;
	}

	public void setSucursalBusiness(SucursalBusiness sucursalBusiness) {
		this.sucursalBusiness = sucursalBusiness;
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

	public OrdenCompra getOrdenCompraSelect() {
		return ordenCompraSelect;
	}

	public void setOrdenCompraSelect(OrdenCompra ordenCompraSelect) {
		this.ordenCompraSelect = ordenCompraSelect;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
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

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
