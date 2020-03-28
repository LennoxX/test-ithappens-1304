package com.teste.ithappens.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.ithappens.entity.Cliente;
import com.teste.ithappens.exceptions.CustomException;
import com.teste.ithappens.repository.ClienteRepository;
import com.teste.ithappens.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente create(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get();
		} else {
			throw new CustomException("Cliente não encontrado", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Page<Cliente> findAllByPage(Pageable page) {
		return repository.findAll(page);
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Cliente> findByParameter(String parameter) {
		return repository.findByNomeContainingIgnoreCaseOrCpfContainingIgnoreCase(parameter, parameter);
	}

}
