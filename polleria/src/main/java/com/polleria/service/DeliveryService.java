package com.polleria.service;

import java.util.List;

import com.polleria.entity.Delivery;

public interface DeliveryService extends CrudService<Delivery, Long> {
	public List<Delivery> fechfindByid(Long id);
}
