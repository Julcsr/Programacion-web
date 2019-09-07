package com.hampcode.business;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Supplier;
import com.hampcode.model.repository.SupplierRepository;

@Named
public class SupplierBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SupplierRepository supplierRepository;

	@Transactional 
	public double insert(Supplier supplier) throws Exception {
		return supplierRepository.insert(supplier);
	}

	
	@Transactional
	public double update(Supplier supplier) throws Exception{
		return supplierRepository.update(supplier);
	}
	
	
	public List<Supplier> getAll() throws Exception {
		return supplierRepository.findAll();
	}
	
	
	public List<Supplier> getSuppliersByName(String name) throws Exception{
		return supplierRepository.findByName(name);
		//:v
	}

}
