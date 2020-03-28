package com.teste.ithappens.service;

import java.util.List;

import com.teste.ithappens.entity.ItemPedido;

public interface ItemPedidoService {

	ItemPedido create(ItemPedido itemPedido);

	ItemPedido update(ItemPedido itemPedido);

	ItemPedido findById(Long id);

	List<ItemPedido> findByPedidoEstoqueId(Long pedidoEstoqueId);

}
