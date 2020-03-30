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
import com.teste.ithappens.entity.Filial;
import com.teste.ithappens.service.FilialService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/filial")
@CrossOrigin("*")
public class FilialResource {

	@Autowired
	private FilialService service;

	@PostMapping
	@ApiOperation(value = "CREATE - Criar uma nova filial")
	public ResponseEntity<Response<Filial>> create(@RequestBody Filial filial) {
		Response<Filial> response = new Response<>();
		response.setData(service.create(filial));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	@ApiOperation(value = "UPDATE - Atualiza uma filial existente")
	public ResponseEntity<Response<Filial>> update(@RequestBody Filial filial) {
		Response<Filial> response = new Response<>();
		response.setData(service.update(filial));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping(value = "{page}/{count}")
	@ApiOperation(value = "FIND ALL BY PAGE - Recupera informações das filiais cadastradas de forma paginada, informando uma página e uma quantidade de registros por página")
	public ResponseEntity<Response<Page<Filial>>> findAllByPage(@PathVariable int page, @PathVariable int count) {
		Response<Page<Filial>> response = new Response<>();
		Pageable pageable = PageRequest.of(page, count);
		Page<Filial> filials = service.findAllByPage(pageable);
		response.setData(filials);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@ApiOperation(value = "FIND ALL - Recupera informações das filiais cadastrados")
	public ResponseEntity<Response<List<Filial>>> findAll() {
		Response<List<Filial>> response = new Response<>();
		List<Filial> filials = service.findAll();
		response.setData(filials);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	@ApiOperation(value = "FIND BY ID - Recupera informações de um estoque em específico através de seu ID")
	public ResponseEntity<Response<Filial>> findById(@PathVariable Long id) {
		Response<Filial> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

}
