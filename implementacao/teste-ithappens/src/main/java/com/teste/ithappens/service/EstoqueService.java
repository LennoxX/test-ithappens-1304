package com.teste.ithappens.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teste.ithappens.entity.Estoque;

public interface EstoqueService {

	Estoque create(Estoque estoque);

	Estoque update(Estoque estoque);

	Estoque findById(Long id);
	
	Estoque findByFilialId(Long filialId);
	
	Page<Estoque> findAllByPage(Pageable page);

	List<Estoque> findAll();
}
