package com.teste.ithappens.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ithappens.entity.Filial;

public interface FilialRepository extends JpaRepository<Filial, Long> {

	Optional<Filial> findByCodigo(Long codigo);

}
