package com.teste.ithappens.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.ithappens.entity.ItemPedido;
import com.teste.ithappens.exceptions.CustomException;
import com.teste.ithappens.repository.ItemPedidoRepository;
import com.teste.ithappens.service.ItemPedidoService;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

	@Autowired
	private ItemPedidoRepository repository;

	@Override
	public ItemPedido create(ItemPedido itemPedido) {
		return repository.save(itemPedido);
	}

	@Override
	public ItemPedido update(ItemPedido itemPedido) {
		return repository.save(itemPedido);
	}

	@Override
	public ItemPedido findById(Long id) {
		Optional<ItemPedido> itemPedido = repository.findById(id);
		if (itemPedido.isPresent()) {
			return itemPedido.get();
		} else {
			throw new CustomException("ItemPedido não encontrado", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<ItemPedido> findByPedidoEstoqueId(Long pedidoEstoqueId) {
		return repository.findByPedidoEstoqueId(pedidoEstoqueId);
	}

}
