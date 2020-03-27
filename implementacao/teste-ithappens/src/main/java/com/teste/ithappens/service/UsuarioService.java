package com.teste.ithappens.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teste.ithappens.entity.Usuario;

public interface UsuarioService {

	Usuario create(Usuario usuario);

	Usuario update(Usuario usuario);

	Usuario findById(Long id);
	
	List<Usuario> findByParameter(String parameter);

	Page<Usuario> findAllByPage(Pageable page);

	List<Usuario> findAll();
}
