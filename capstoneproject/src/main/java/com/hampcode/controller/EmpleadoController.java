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
import com.hampcode.business.EmpleadoBusiness;
import com.hampcode.business.SucursalBusiness;
import com.hampcode.model.entity.Cargo;
import com.hampcode.model.entity.Empleado;
import com.hampcode.model.entity.Sucursal;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class EmpleadoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EmpleadoBusiness empleadoBusiness;

	@Inject
	private CargoBusiness cargoBusiness;

	@Inject
	private SucursalBusiness sucursalBusiness;

	private Empleado empleado;
	private List<Empleado> empleados;
	private Empleado empleadoSelect;

	private Cargo cargo;
	private List<Cargo> cargos;

	private Sucursal sucursal;
	private List<Sucursal> sucursales;

	private String filterName;

	@PostConstruct
	public void init() {
		empleado = new Empleado();
		empleados = new ArrayList<Empleado>();
		empleadoSelect = new Empleado();

		cargo = new Cargo();
		cargos = new ArrayList<Cargo>();

		sucursal = new Sucursal();
		sucursales = new ArrayList<Sucursal>();

		getAllEmpleados();
	}

	public void getAllEmpleados() {
		try {
			empleados = empleadoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Insumos :" + e.getMessage());
		}
	}

	public String newEmpleado() {
		try {
			this.cargos = cargoBusiness.getAll();
			this.sucursales = sucursalBusiness.getAll();
			resetForm();
		} catch (Exception e) {

		}

		return "insert_empleados.xhtml";
	}

	public String listEmpleados() {
		return "list_empleados.xhtml";
	}

	public String saveEmpleado() {
		String view = "";
		try {

			if (empleado.getId() != null) {

				empleado.setCargo(cargo);
				empleado.setSucursal(sucursal);

				empleadoBusiness.update(empleado);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				empleado.setCargo(cargo);
				empleado.setSucursal(sucursal);
				empleadoBusiness.insert(empleado);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllEmpleados();
			resetForm();
			view = "list_empleados";
		} catch (Exception e) {
			Message.messageError("Error Empleado :" + e.getStackTrace());
		}

		return view;
	}

	public String editEmpleado() {
		String view = "";
		try {
			if (this.empleadoSelect != null) {
				this.empleado = empleadoSelect;

				view = "update_empleados";// Vista
			} else {
				Message.messageInfo("Debe seleccionar un empleado");
			}
		} catch (Exception e) {
			Message.messageError("Error empleado :" + e.getMessage());
		}

		return view;
	}

	public void searchEmpleadoByName() {
		try {

			empleados = empleadoBusiness.getEmpleadosByName(this.filterName.trim());
			resetForm();
			if (empleados.isEmpty()) {
				Message.messageInfo("No se encontraron empleados");

			}

		} catch (Exception e) {
			Message.messageError("Error empleado Search :" + e.getMessage());
		}
	}

	public void selectEmpleado(SelectEvent e) {
		this.empleadoSelect = (Empleado) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.empleado = new Empleado();
	}

	public EmpleadoBusiness getEmpleadoBusiness() {
		return empleadoBusiness;
	}

	public void setEmpleadoBusiness(EmpleadoBusiness empleadoBusiness) {
		this.empleadoBusiness = empleadoBusiness;
	}

	public CargoBusiness getCargoBusiness() {
		return cargoBusiness;
	}

	public void setCargoBusiness(CargoBusiness cargoBusiness) {
		this.cargoBusiness = cargoBusiness;
	}

	public SucursalBusiness getSucursalBusiness() {
		return sucursalBusiness;
	}

	public void setSucursalBusiness(SucursalBusiness sucursalBusiness) {
		this.sucursalBusiness = sucursalBusiness;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado getEmpleadoSelect() {
		return empleadoSelect;
	}

	public void setEmpleadoSelect(Empleado empleadoSelect) {
		this.empleadoSelect = empleadoSelect;
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
