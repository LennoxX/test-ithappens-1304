package com.teste.ithappens.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.ithappens.entity.Filial;
import com.teste.ithappens.exceptions.CustomException;
import com.teste.ithappens.repository.FilialRepository;
import com.teste.ithappens.service.FilialService;

@Service
public class FilialServiceImpl implements FilialService {

	@Autowired
	private FilialRepository repository;

	@Override
	public Filial create(Filial filial) {
		return repository.save(filial);
	}

	@Override
	public Filial update(Filial filial) {
		return repository.save(filial);
	}

	@Override
	public Filial findById(Long id) {
		Optional<Filial> filial = repository.findById(id);
		if (filial.isPresent()) {
			return filial.get();
		} else {
			throw new CustomException("Filial não encontrada", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Page<Filial> findAllByPage(Pageable page) {
		return repository.findAll(page);
	}

	@Override
	public List<Filial> findAll() {
		return repository.findAll();
	}

}
