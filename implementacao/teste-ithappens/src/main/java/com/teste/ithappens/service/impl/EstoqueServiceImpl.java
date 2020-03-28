package com.teste.ithappens.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.ithappens.entity.Estoque;
import com.teste.ithappens.exceptions.CustomException;
import com.teste.ithappens.repository.EstoqueRepository;
import com.teste.ithappens.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService {

	@Autowired
	private EstoqueRepository repository;

	@Override
	public Estoque create(Estoque estoque) {
		return repository.save(estoque);
	}

	@Override
	public Estoque update(Estoque estoque) {
		return repository.save(estoque);
	}

	@Override
	public Estoque findById(Long id) {
		Optional<Estoque> estoque = repository.findById(id);
		if (estoque.isPresent()) {
			return estoque.get();
		} else {
			throw new CustomException("Estoque não encontrado", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Page<Estoque> findAllByPage(Pageable page) {
		return repository.findAll(page);
	}

	@Override
	public List<Estoque> findAll() {
		return repository.findAll();
	}
	@Override
	public Estoque findByFilialId(Long filialId) {
		return repository.findByFilial_id(filialId);
	}

}
 