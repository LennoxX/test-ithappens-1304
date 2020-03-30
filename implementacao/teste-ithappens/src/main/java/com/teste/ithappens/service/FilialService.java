package com.teste.ithappens.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teste.ithappens.entity.Filial;

public interface FilialService {

	Filial create(Filial filial);

	Filial update(Filial filial);

	Filial findById(Long id);

	Page<Filial> findAllByPage(Pageable page);

	List<Filial> findAll();
}
