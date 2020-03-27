package com.teste.ithappens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ithappens.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNomeContainingIgnoreCaseOrCpfContainingIgnoreCase(String nome, String cpf);

}
