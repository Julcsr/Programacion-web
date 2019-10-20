package com.polleria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.entity.Position;
import com.polleria.repository.PositionRepository;
import com.polleria.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionRepository positionRepository;
	
	@Override
	public List<Position> getAll() {
		// TODO Auto-generated method stub
		return positionRepository.findAll();
	}

	@Override
	public Position getOneById(Long id) {
		// TODO Auto-generated method stub
		return positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));
	}

	@Override
	public Long create(Position entity) {
		// TODO Auto-generated method stub
		positionRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Position entity) {
		// TODO Auto-generated method stub
		positionRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		positionRepository.deleteById(id);
	}
	
}
