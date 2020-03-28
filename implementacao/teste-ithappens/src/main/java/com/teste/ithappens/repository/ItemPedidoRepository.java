package com.teste.ithappens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ithappens.entity.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

	List<ItemPedido> findByPedidoEstoqueId(Long pedidoEstoqueId);

}
