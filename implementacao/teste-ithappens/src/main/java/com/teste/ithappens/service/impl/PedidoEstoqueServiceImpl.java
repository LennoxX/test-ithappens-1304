package com.teste.ithappens.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.ithappens.entity.PedidoEstoque;
import com.teste.ithappens.exceptions.CustomException;
import com.teste.ithappens.repository.PedidoEstoqueRepository;
import com.teste.ithappens.service.PedidoEstoqueService;

@Service
public class PedidoEstoqueServiceImpl implements PedidoEstoqueService {

	@Autowired
	private PedidoEstoqueRepository repository;

	@Override
	public PedidoEstoque create(PedidoEstoque pedidoEstoque) {
		return repository.save(pedidoEstoque);
	}

	@Override
	public PedidoEstoque update(PedidoEstoque pedidoEstoque) {
		return repository.save(pedidoEstoque);
	}

	@Override
	public PedidoEstoque findById(Long id) {
		Optional<PedidoEstoque> pedidoEstoque = repository.findById(id);
		if (pedidoEstoque.isPresent()) {
			return pedidoEstoque.get();
		} else {
			throw new CustomException("PedidoEstoque não encontrado", HttpStatus.BAD_REQUEST);
		}
	}

}
