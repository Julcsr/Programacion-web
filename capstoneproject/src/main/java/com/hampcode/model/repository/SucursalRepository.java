package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Sucursal;

public class SucursalRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Sucursal sucursal) throws Exception {
		em.persist(sucursal);
		return sucursal.getCSucursal();
	}
	
	
	public Long update(Sucursal sucursal) throws Exception {
		em.merge(sucursal);
		return sucursal.getCSucursal();
	}
	
	
	public void delete(Sucursal sucursal) throws Exception {
		em.remove(sucursal);
	}
	
	
	public List<Sucursal > findAll() throws Exception{
		List<Sucursal > sucursals=new ArrayList<>();
		
		TypedQuery<Sucursal > query=em.createQuery("FROM Sucursal s"
				,Sucursal.class);
		sucursals=query.getResultList();
		
		return sucursals;
	}
	
	
	public Optional<Sucursal > findById(Long id) throws Exception{
		Sucursal sucursalFound;
		
		TypedQuery<Sucursal > query=em.createQuery("FROM Product p WHERE p.id=?1"
				,Sucursal.class);
		
		query.setParameter(1, id);
		sucursalFound=query.getSingleResult();
		
		return Optional.of(sucursalFound);
	}
	
	
	public List<Sucursal> findByName(String name) throws Exception{
		List<Sucursal> sucursals=new ArrayList<>();
		
		TypedQuery<Sucursal> query=em.createQuery("FROM Sucursal s WHERE s.NSucursal LIKE ?1"
				,Sucursal.class);
		query.setParameter(1, "%"+name+"%");
		sucursals=query.getResultList();
		
		return sucursals;
	}
	
	

}

