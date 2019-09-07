package com.hampcode.model.repository;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Supplier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
public class SupplierRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Supplier supplier) throws Exception {
		em.persist(supplier);
		return supplier.getCProveedor();
	}
	
	
	public Long update(Supplier supplier) throws Exception {
		em.merge(supplier);
		return supplier.getCProveedor();
	}
	
	
	public void delete(Supplier supplier) throws Exception {
		em.remove(supplier);
	}
	
	
	public List<Supplier > findAll() throws Exception{
		List<Supplier > suppliers=new ArrayList<>();
		
		TypedQuery<Supplier > query=em.createQuery("FROM Product p"
				,Supplier.class);
		suppliers=query.getResultList();
		
		return suppliers;
	}
	
	
	public Optional<Supplier > findById(Long id) throws Exception{
		Supplier supplierFound;
		
		TypedQuery<Supplier > query=em.createQuery("FROM Product p WHERE p.id=?1"
				,Supplier.class);
		
		query.setParameter(1, id);
		supplierFound=query.getSingleResult();
		
		return Optional.of(supplierFound);
	}
	
	
	public List<Supplier> findByName(String name) throws Exception{
		List<Supplier> suppliers=new ArrayList<>();
		
		TypedQuery<Supplier> query=em.createQuery("FROM Supplier s WHERE s.NProveedor LIKE ?1"
				,Supplier.class);
		query.setParameter(1, "%"+name+"%");
		suppliers=query.getResultList();
		
		return suppliers;
	}
	
	

}



