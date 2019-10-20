package com.polleria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.entity.Office;
import com.polleria.repository.OfficeRepository;
import com.polleria.service.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService{
	@Autowired
	private OfficeRepository officeRepository;

	@Override
	public List<Office> getAll() {
		// TODO Auto-generated method stub
		return officeRepository.findAll();	}

	@Override
	public Office getOneById(Long id) {
		return officeRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));

	}

	@Override
	public Long create(Office entity) {
		officeRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Office entity) {
		officeRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		officeRepository.deleteById(id);
		
	}
	
	
}
