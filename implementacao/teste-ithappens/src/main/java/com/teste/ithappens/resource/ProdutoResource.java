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
import com.teste.ithappens.entity.Produto;
import com.teste.ithappens.service.ProdutoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin("*")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@PostMapping
	@ApiOperation(value = "CREATE - Criar um novo produto")
	public ResponseEntity<Response<Produto>> create(@RequestBody Produto produto) {
		Response<Produto> response = new Response<>();
		response.setData(service.create(produto));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	@ApiOperation(value = "UPDATE - Atualiza um produto existente")
	public ResponseEntity<Response<Produto>> update(@RequestBody Produto produto) {
		Response<Produto> response = new Response<>();
		response.setData(service.update(produto));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping(value = "{page}/{count}")
	@ApiOperation(value = "FIND ALL BY PAGE - Recupera informações dos produtos cadastrados de forma paginada, informando uma página e uma quantidade de registros por página")
	public ResponseEntity<Response<Page<Produto>>> findAllByPage(@PathVariable int page, @PathVariable int count) {
		Response<Page<Produto>> response = new Response<>();
		Pageable pageable = PageRequest.of(page, count);
		Page<Produto> produtos = service.findAllByPage(pageable);
		response.setData(produtos);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@ApiOperation(value = "FIND ALL - Recupera informações dos produtos cadastrados")
	public ResponseEntity<Response<List<Produto>>> findAll() {
		Response<List<Produto>> response = new Response<>();
		List<Produto> produtos = service.findAll();
		response.setData(produtos);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	@ApiOperation(value = "FIND BY ID - Recupera informações de um produto em específico através de seu ID")
	public ResponseEntity<Response<Produto>> findById(@PathVariable Long id) {
		Response<Produto> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

	@GetMapping("parameter/{parameter}")
	@ApiOperation(value = "FIND BY PARAMETER - Recupera informações dos produtos cadastrados através de um parâmetro (nome, descrição...)")
	public ResponseEntity<Response<List<Produto>>> findByParameter(@PathVariable String parameter) {
		Response<List<Produto>> response = new Response<>();
		response.setData(service.findByParameter(parameter));
		return ResponseEntity.ok(response);
	}

}
