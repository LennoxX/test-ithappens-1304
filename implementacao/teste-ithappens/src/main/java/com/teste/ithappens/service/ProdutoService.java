package com.teste.ithappens.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teste.ithappens.entity.Produto;

public interface ProdutoService {

	Produto create(Produto produto);

	Produto update(Produto produto);

	Produto findById(Long id);
	
	List<Produto> findByParameter(String parameter);

	Page<Produto> findAllByPage(Pageable page);

	List<Produto> findAll();
}
