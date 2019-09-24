package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Sabor;
import com.hampcode.model.repository.SaborRepository;

@Named
public class SaborBusiness implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private SaborRepository saborRepository;

	@Transactional
	public Long insert(Sabor sabor) throws Exception {
		return saborRepository.insert(sabor);
	}

	@Transactional
	public Long update(Sabor sabor) throws Exception {
		return saborRepository.update(sabor);
	}

	public List<Sabor> getAll() throws Exception {
		return saborRepository.findAll();
	}
}
