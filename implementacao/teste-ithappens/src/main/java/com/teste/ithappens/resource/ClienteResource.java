package com.teste.ithappens.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.ithappens.dto.Response;
import com.teste.ithappens.entity.Cliente;
import com.teste.ithappens.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@PostMapping
	@ApiOperation(value = "CREATE - Criar um novo cliente")
	public ResponseEntity<Response<Cliente>> create(@RequestBody Cliente cliente) {
		Response<Cliente> response = new Response<>();
		response.setData(service.create(cliente));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	@ApiOperation(value = "UPDATE - Atualiza um cliente existente")
	public ResponseEntity<Response<Cliente>> update(@RequestBody Cliente cliente) {
		Response<Cliente> response = new Response<>();
		response.setData(service.update(cliente));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping(value = "{page}/{count}")
	@ApiOperation(value = "FIND ALL BY PAGE - Recupera informações dos clientes cadastrados de forma paginada, informando uma página e uma quantidade de registros por página")
	public ResponseEntity<Response<Page<Cliente>>> findAllByPage(@PathVariable int page, @PathVariable int count) {
		Response<Page<Cliente>> response = new Response<>();
		Pageable pageable = PageRequest.of(page, count);
		Page<Cliente> clientes = service.findAllByPage(pageable);
		response.setData(clientes);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@ApiOperation(value = "FIND ALL - Recupera informações dos clientes cadastrados")
	public ResponseEntity<Response<List<Cliente>>> findAll() {
		Response<List<Cliente>> response = new Response<>();
		List<Cliente> clientes = service.findAll();
		response.setData(clientes);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	@ApiOperation(value = "FIND BY ID - Recupera informações de um cliente em específico através de seu ID")
	public ResponseEntity<Response<Cliente>> findById(@PathVariable Long id) {
		Response<Cliente> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

	@GetMapping("parameter/{parameter}")
	@ApiOperation(value = "FIND BY PARAMETER - Recupera informações dos clientes cadastrados através de um parâmetro (nome, cpf...)")
	public ResponseEntity<Response<List<Cliente>>> findByParameter(@PathVariable String parameter) {
		Response<List<Cliente>> response = new Response<>();
		response.setData(service.findByParameter(parameter));
		return ResponseEntity.ok(response);
	}

}
