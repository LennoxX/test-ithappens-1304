package com.teste.ithappens.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teste.ithappens.entity.Cliente;

public interface ClienteService {

	Cliente create(Cliente cliente);

	Cliente update(Cliente cliente);

	Cliente findById(Long id);
	
	List<Cliente> findByParameter(String parameter);

	Page<Cliente> findAllByPage(Pageable page);

	List<Cliente> findAll();
}
