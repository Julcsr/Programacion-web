package com.hampcode.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import org.primefaces.event.SelectEvent;

import com.hampcode.business.InsumoBusiness;
import com.hampcode.business.MarcaBusiness;
import com.hampcode.business.SaborBusiness;
import com.hampcode.business.UnidadBusiness;
import com.hampcode.model.entity.Correo;
import com.hampcode.model.entity.Insumo;
import com.hampcode.model.entity.Marca;
import com.hampcode.model.entity.Sabor;
import com.hampcode.model.entity.Unidad;
import com.hampcode.util.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class InsumoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private InsumoBusiness insumoBusiness;

	@Inject
	private UnidadBusiness unidadBusiness;

	@Inject
	private MarcaBusiness marcaBusiness;

	@Inject
	private SaborBusiness saborBusiness;

	private Insumo insumo;
	private List<Insumo> insumos;
	private Insumo insumoSelect;

	private Unidad unidad;
	private List<Unidad> unidades;

	private Marca marca;
	private List<Marca> marcas;

	private Sabor sabor;
	private List<Sabor> sabores;

	private String filterName;
	
	private Correo c=new Correo();

	@PostConstruct
	public void init() {
		insumo = new Insumo();
		insumos = new ArrayList<Insumo>();
		insumoSelect = new Insumo();

		unidad = new Unidad();
		unidades = new ArrayList<Unidad>();

		marca = new Marca();
		marcas = new ArrayList<Marca>();

		sabor = new Sabor();
		sabores = new ArrayList<Sabor>();

		getAllInsumos();
	}

	public void enviarCorreo(Insumo insumo) {
		c.setContrasenia("gkthyjfuxnmegynh");
		c.setUsuario("jeffams1234@gmail.com");
		c.setAsunto("Insumos");
		c.setMensaje("Se registro el insumo "+insumo.getNombreInsumo());
		c.setDestino("meliodasams1234@gmail.com");
		c.setNombreArchivo("");
		c.setRutaArchivo("");
		CorreoController co=new CorreoController();
		if(co.enviarCorreo(c)) {
			Message.messageInfo("Envio");
		}else {
			Message.messageInfo("Error");
		}
	}
	
	public void getAllInsumos() {
		try {
			insumos = insumoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Insumos :" + e.getMessage());
		}
	}

	public String newInsumo() {
		try {
			this.unidades = unidadBusiness.getAll();
			this.marcas = marcaBusiness.getAll();
			this.sabores = saborBusiness.getAll();
			resetForm();
		} catch (Exception e) {

		}

		return "insert_insumos.xhtml";
	}

	public String listInsumos() {
		resetForm();
		return "list_insumos.xhtml";
	}

	public String saveInsumo() {
		String view = "";
		try {

			if (insumo.getIdInsumo() != null) {

				insumo.setMarcaInsumo(marca);
				insumo.setSaborInsumo(sabor);
				insumo.setUnidadInsumo(unidad);

				insumoBusiness.update(insumo);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				insumo.setMarcaInsumo(marca);
				insumo.setSaborInsumo(sabor);
				insumo.setUnidadInsumo(unidad);
				insumoBusiness.insert(insumo);
				//enviarCorreo(insumo);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllInsumos();
			resetForm();
			view = "list_insumos";
		} catch (Exception e) {
			Message.messageError("Error Insumo :" + e.getStackTrace());
		}

		return view;
	}

	public String editInsumo() {
		String view = "";
		try {
			if (this.insumoSelect != null) {
				this.insumo = insumoSelect;

				view = "update_insumos";// Vista
			} else {
				Message.messageInfo("Debe seleccionar un insumo");
			}
		} catch (Exception e) {
			Message.messageError("Error insumo :" + e.getMessage());
		}

		return view;
	}

	public void searchInsumoByName() {
		try {

			insumos = insumoBusiness.getInsumosByName(this.filterName.trim());
			resetForm();
			if (insumos.isEmpty()) {
				Message.messageInfo("No se encontraron productos");

			}

		} catch (Exception e) {
			Message.messageError("Error Product Search :" + e.getMessage());
		}
	}

	public void selectInsumo(SelectEvent e) {
		this.insumoSelect = (Insumo) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.insumo = new Insumo();
	}

	public InsumoBusiness getInsumoBusiness() {
		return insumoBusiness;
	}

	public void setInsumoBusiness(InsumoBusiness insumoBusiness) {
		this.insumoBusiness = insumoBusiness;
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

	public Insumo getInsumoSelect() {
		return insumoSelect;
	}

	public void setInsumoSelect(Insumo insumoSelect) {
		this.insumoSelect = insumoSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
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

	public MarcaBusiness getMarcaBusiness() {
		return marcaBusiness;
	}

	public void setMarcaBusiness(MarcaBusiness marcaBusiness) {
		this.marcaBusiness = marcaBusiness;
	}

	public SaborBusiness getSaborBusiness() {
		return saborBusiness;
	}

	public void setSaborBusiness(SaborBusiness saborBusiness) {
		this.saborBusiness = saborBusiness;
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

}
