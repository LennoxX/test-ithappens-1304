package com.teste.ithappens.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.ithappens.entity.Estoque;
import com.teste.ithappens.entity.ItemPedido;
import com.teste.ithappens.entity.PedidoEstoque;
import com.teste.ithappens.enums.TpStatusItemPedido;
import com.teste.ithappens.enums.TpTipoPedido;
import com.teste.ithappens.exceptions.CustomException;
import com.teste.ithappens.repository.EstoqueRepository;
import com.teste.ithappens.repository.PedidoEstoqueRepository;
import com.teste.ithappens.service.PedidoEstoqueService;

@Service
public class PedidoEstoqueServiceImpl implements PedidoEstoqueService {

	@Autowired
	private PedidoEstoqueRepository repository;

	@Autowired
	private EstoqueRepository estoqueRepository;

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

	@Override
	public PedidoEstoque addItem(ItemPedido itemPedido, Long idPedidoEstoque) {
		Optional<PedidoEstoque> pedidoEstoque = repository.findById(idPedidoEstoque);

		// VERIFICANDO SE O PEDIDOESTOQUE EXISTE
		if (pedidoEstoque.isPresent()) {
			PedidoEstoque temp = pedidoEstoque.get();
			for (ItemPedido item : temp.getItens()) {

				// VERIFICANDO SE JÁ EXISTE ESSE PRODUTO NO PEDIDO E SE O MESMO ESTÁ COMO ATIVO
				if (item.getProduto().getId() == itemPedido.getProduto().getId() && item.getStatus() == TpStatusItemPedido.ATIVO) {
					throw new CustomException("Produto já existe neste pedido!", HttpStatus.BAD_REQUEST);
				}
			}

			// DEFININDO O VALOR TOTAL DO ITEM, MULTIPLICANDO A QUANTIDADE PELO VALOR
			// UNITARIO
			itemPedido
					.setValorTotal(new BigDecimal(itemPedido.getQuantidade()).multiply(itemPedido.getValorUnitario()));

			itemPedido.setPedidoEstoque(pedidoEstoque.get());

			// RECUPERANDO O ESTOQUE DO PRODUTO NA FILIAL
			Estoque estoque = estoqueRepository.findByProdutoIdAndFilialId(itemPedido.getProduto().getId(),
					itemPedido.getPedidoEstoque().getFilial().getId());

			// VERIFICANDO SE É UMA VENDA E SE A QUANTIDADE EM ESTOQUE É SUFICIENTE PARA A
			// QUANTIDADE PEDIDA
			if (temp.getTpTipoPedido() == TpTipoPedido.SAIDA && estoque.getQuantidade() < itemPedido.getQuantidade()) {
				throw new CustomException(
						"Capacidade selecionada é superior à quantidade em estoque. Máximo do estoque: "
								+ estoque.getQuantidade(),
						HttpStatus.BAD_REQUEST);

			}
			// DEFININDO O ITEM COMO ATIVO
			itemPedido.setStatus(TpStatusItemPedido.ATIVO);

			// ADICIONANDO À LISTA DE ITENS DO PEDIDO
			temp.getItens().add(itemPedido);

			// ATUALIZANDO O TOTAL DE ITENS E O VALOR TOTAL DO PEDIDO
			temp.setTotalItens(temp.getTotalItens() + itemPedido.getQuantidade());
			
			if (temp.getValorTotal() != null) {
				temp.setValorTotal(temp.getValorTotal().add(itemPedido.getValorTotal()));
			}
			else {
				temp.setValorTotal(itemPedido.getValorTotal());
			}

			// SALVANDO O PEDIDO COM OS NOVOS VALORES E ITENS
			return update(temp);
		} else {
			throw new CustomException("PedidoEstoque não encontrado", HttpStatus.BAD_REQUEST);
		}
	}

}
