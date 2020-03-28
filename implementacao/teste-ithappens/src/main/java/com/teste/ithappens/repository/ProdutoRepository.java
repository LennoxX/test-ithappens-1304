package com.teste.ithappens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ithappens.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNomeContainingIgnoreCaseOrCodigoBarrasContainingOrDescricaoContainingIgnoreCase(String nome,
			String codigoBarras, String descricao);

}
