package com.teste.ithappens.service;

import com.teste.ithappens.entity.PedidoEstoque;

public interface PedidoEstoqueService {

	PedidoEstoque create(PedidoEstoque pedidoEstoque);

	PedidoEstoque update(PedidoEstoque pedidoEstoque);

	PedidoEstoque findById(Long id);

}
