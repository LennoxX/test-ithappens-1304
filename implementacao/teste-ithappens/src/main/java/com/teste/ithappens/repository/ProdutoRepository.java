package com.teste.ithappens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ithappens.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
