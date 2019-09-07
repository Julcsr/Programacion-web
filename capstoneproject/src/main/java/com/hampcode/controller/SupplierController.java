package com.hampcode.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.SupplierBusiness;
import com.hampcode.model.entity.Supplier;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class SupplierController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SupplierBusiness supplierBusiness;

	private Supplier supplier; //NuevoSuppliero
	private List<Supplier> suppliers;//ListaSupplieros
	private Supplier supplierSelect;//Suppliero Seleccionado Editar
	private String filterName;// Criterio de Busqueda

	@PostConstruct
	public void init() {
		supplier = new Supplier();
		suppliers = new ArrayList<Supplier>();
		getAllSuppliers();
	}

	public void getAllSuppliers() {
		try {
			suppliers = supplierBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Supplieros :" + e.getMessage());
		}
	}

	public String newSupplier() {
		resetForm();
		return "insert.xhtml";
	}

	public String listSupplier() {
		return "list.xhtml";
	}

	public String saveSupplier() {
		String view = "";
		try {

			if (supplier.getCProveedor()!=null) {
				supplierBusiness.update(supplier);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				supplierBusiness.insert(supplier);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllSuppliers();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Supplier :" + e.getStackTrace());
		}

		return view;
	}

	public String editSupplier() {
		String view = "";
		try {
			if (this.supplierSelect != null) {
				this.supplier = supplierSelect;

				view = "update";// Vista
			} else {
				Message.messageInfo("Debe seleccionar un proveedor");
			}
		} catch (Exception e) {
			Message.messageError("Error Supplier :" + e.getMessage());
		}

		return view;
	}

	public void searchSupplierByName() {
		try {

			suppliers = supplierBusiness.getSuppliersByName(this.filterName.trim());
			resetForm();
			if (suppliers.isEmpty()) {
				Message.messageInfo("No se encontraron supplieros");

			}

		} catch (Exception e) {
			Message.messageError("Error Supplier Search :" + e.getMessage());
		}
	}

	public void selectSupplier(SelectEvent e) {
		this.supplierSelect = (Supplier) e.getObject();
	}

	public void resetForm() {
		this.filterName="";
		this.supplier = new Supplier();
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

	public Supplier getSupplierSelect() {
		return supplierSelect;
	}

	public void setSupplierSelect(Supplier supplierSelect) {
		this.supplierSelect = supplierSelect;
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
