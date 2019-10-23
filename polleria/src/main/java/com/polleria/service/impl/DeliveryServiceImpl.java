package com.polleria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.entity.Delivery;
import com.polleria.repository.DeliveryRepository;
import com.polleria.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;

	@Override
	public List<Delivery> getAll() {
		// TODO Auto-generated method stub
		return deliveryRepository.findAll();
	}

	@Override
	public Delivery getOneById(Long id) {
		// TODO Auto-generated method stub
		return deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));

	}

	@Override
	public Long create(Delivery entity) {
		deliveryRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Delivery entity) {
		deliveryRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		deliveryRepository.deleteById(id);
	}

	@Override
	public List<Delivery> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Delivery> fechfindByid(Long id) {
		// TODO Auto-generated method stub
		return this.deliveryRepository.fechfindByid(id);
	}

}
