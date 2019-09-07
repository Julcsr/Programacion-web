package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Sucursal;
import com.hampcode.model.repository.SucursalRepository;

public class SucursalBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SucursalRepository sucursalRepository;

	@Transactional 
	public double insert(Sucursal sucursal) throws Exception {
		return sucursalRepository.insert(sucursal);
	}

	
	@Transactional
	public double update(Sucursal sucursal) throws Exception{
		return sucursalRepository.update(sucursal);
	}
	
	
	public List<Sucursal> getAll() throws Exception {
		return sucursalRepository.findAll();
	}
	
	
	public List<Sucursal> getSucursalsByName(String name) throws Exception{
		return sucursalRepository.findByName(name);
	}
}