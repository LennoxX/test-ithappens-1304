package com.teste.ithappens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ithappens.entity.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	Estoque findByFilial_id(Long filialId);

	Estoque findByProdutoIdAndFilialId(Long id, Long id2);

}
