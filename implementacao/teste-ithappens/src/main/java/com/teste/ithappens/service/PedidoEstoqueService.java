package com.teste.ithappens.service;

import com.teste.ithappens.entity.ItemPedido;
import com.teste.ithappens.entity.PedidoEstoque;
import com.teste.ithappens.enums.TpFormaPagamento;

public interface PedidoEstoqueService {

	PedidoEstoque create(PedidoEstoque pedidoEstoque);

	PedidoEstoque update(PedidoEstoque pedidoEstoque);

	PedidoEstoque findById(Long id);

	PedidoEstoque addItem(ItemPedido itemPedido, Long idPedidoEstoque);
	
	PedidoEstoque removeItem(Long idItemPedido);

	PedidoEstoque processar(Long idPedidoEstoque, TpFormaPagamento tpFormaPagamento);

}
