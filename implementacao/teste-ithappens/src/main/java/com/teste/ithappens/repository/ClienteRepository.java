package com.teste.ithappens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ithappens.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
