package com.teste.ithappens.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.ithappens.entity.Produto;
import com.teste.ithappens.exceptions.CustomException;
import com.teste.ithappens.repository.ProdutoRepository;
import com.teste.ithappens.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Override
	public Produto create(Produto produto) {
		return repository.save(produto);
	}

	@Override
	public Produto update(Produto produto) {
		return repository.save(produto);
	}

	@Override
	public Produto findById(Long id) {
		Optional<Produto> produto = repository.findById(id);
		if (produto.isPresent()) {
			return produto.get();
		} else {
			throw new CustomException("Produto não encontrado", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Page<Produto> findAllByPage(Pageable page) {
		return repository.findAll(page);
	}

	@Override
	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Produto> findByParameter(String parameter) {
		return repository.findByNomeContainingIgnoreCaseOrCodigoBarrasContainingOrDescricaoContainingIgnoreCase(parameter, parameter, parameter);
	}

}
 