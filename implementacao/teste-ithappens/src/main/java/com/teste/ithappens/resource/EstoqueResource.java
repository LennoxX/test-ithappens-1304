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
import com.teste.ithappens.entity.Estoque;
import com.teste.ithappens.service.EstoqueService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/estoque")
@CrossOrigin("*")
public class EstoqueResource {

	@Autowired
	private EstoqueService service;

	@PostMapping
	@ApiOperation(value = "CREATE - Criar um novo estoque")
	public ResponseEntity<Response<Estoque>> create(@RequestBody Estoque estoque) {
		Response<Estoque> response = new Response<>();
		response.setData(service.create(estoque));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	@ApiOperation(value = "UPDATE - Atualiza um estoque existente")
	public ResponseEntity<Response<Estoque>> update(@RequestBody Estoque estoque) {
		Response<Estoque> response = new Response<>();
		response.setData(service.update(estoque));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping(value = "{page}/{count}")
	@ApiOperation(value = "FIND ALL BY PAGE - Recupera informações dos estoques cadastrados de forma paginada, informando uma página e uma quantidade de registros por página")
	public ResponseEntity<Response<Page<Estoque>>> findAllByPage(@PathVariable int page, @PathVariable int count) {
		Response<Page<Estoque>> response = new Response<>();
		Pageable pageable = PageRequest.of(page, count);
		Page<Estoque> estoques = service.findAllByPage(pageable);
		response.setData(estoques);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@ApiOperation(value = "FIND ALL - Recupera informações dos estoques cadastrados")
	public ResponseEntity<Response<List<Estoque>>> findAll() {
		Response<List<Estoque>> response = new Response<>();
		List<Estoque> estoques = service.findAll();
		response.setData(estoques);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	@ApiOperation(value = "FIND BY ID - Recupera informações de um estoque em específico através de seu ID")
	public ResponseEntity<Response<Estoque>> findById(@PathVariable Long id) {
		Response<Estoque> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

	@GetMapping("filial/{id}")
	@ApiOperation(value = "FIND BY FILIAL - Recupera informações de um estoque através do ID de uma filial")
	public ResponseEntity<Response<Estoque>> findByFilial(@PathVariable Long id) {
		Response<Estoque> response = new Response<>();
		response.setData(service.findByFilialId(id));
		return ResponseEntity.ok(response);
	}

}
