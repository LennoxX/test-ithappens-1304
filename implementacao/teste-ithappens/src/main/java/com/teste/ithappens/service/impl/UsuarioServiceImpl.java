package com.teste.ithappens.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.ithappens.entity.Usuario;
import com.teste.ithappens.exceptions.CustomException;
import com.teste.ithappens.repository.UsuarioRepository;
import com.teste.ithappens.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario create(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new CustomException("Usuário não encontrado", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Page<Usuario> findAllByPage(Pageable page) {
		return repository.findAll(page);
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Usuario> findByParameter(String parameter) {
		return repository.findByNomeContainingIgnoreCaseOrCpfContainingIgnoreCase(parameter, parameter);
	}

}
