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

@RestController
@RequestMapping("/api/estoque")
@CrossOrigin("*")
public class EstoqueResource {

	@Autowired
	private EstoqueService service;

	@PostMapping
	public ResponseEntity<Response<Estoque>> create(@RequestBody Estoque estoque) {
		Response<Estoque> response = new Response<>();
		response.setData(service.create(estoque));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	public ResponseEntity<Response<Estoque>> update(@RequestBody Estoque estoque) {
		Response<Estoque> response = new Response<>();
		response.setData(service.update(estoque));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<Page<Estoque>>> findAllByPage(@PathVariable int page, @PathVariable int count) {
		Response<Page<Estoque>> response = new Response<>();
		Pageable pageable = PageRequest.of(page, count);
		Page<Estoque> estoques = service.findAllByPage(pageable);
		response.setData(estoques);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<Response<List<Estoque>>> findAll() {
		Response<List<Estoque>> response = new Response<>();
		List<Estoque> estoques = service.findAll();
		response.setData(estoques);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	public ResponseEntity<Response<Estoque>> findById(@PathVariable Long id) {
		Response<Estoque> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

	@GetMapping("filial/{id}")
	public ResponseEntity<Response<Estoque>> findByFilial(@PathVariable Long id) {
		Response<Estoque> response = new Response<>();
		response.setData(service.findByFilialId(id));
		return ResponseEntity.ok(response);
	}

}
