package com.teste.ithappens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ithappens.entity.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
