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
import com.teste.ithappens.entity.Usuario;
import com.teste.ithappens.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@PostMapping
	@ApiOperation(value = "CREATE - Criar um novo usuário")
	public ResponseEntity<Response<Usuario>> create(@RequestBody Usuario usuario) {
		Response<Usuario> response = new Response<>();
		response.setData(service.create(usuario));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	@ApiOperation(value = "UPDATE - Atualiza um usuário existente")
	public ResponseEntity<Response<Usuario>> update(@RequestBody Usuario usuario) {
		Response<Usuario> response = new Response<>();
		response.setData(service.update(usuario));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping(value = "{page}/{count}")
	@ApiOperation(value = "FIND ALL BY PAGE - Recupera informações dos usuários cadastrados de forma paginada, informando uma página e uma quantidade de registros por página")
	public ResponseEntity<Response<Page<Usuario>>> findAllByPage(@PathVariable int page, @PathVariable int count) {
		Response<Page<Usuario>> response = new Response<>();
		Pageable pageable = PageRequest.of(page, count);
		Page<Usuario> usuarios = service.findAllByPage(pageable);
		response.setData(usuarios);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@ApiOperation(value = "FIND ALL - Recupera informações dos usuários cadastrados")
	public ResponseEntity<Response<List<Usuario>>> findAll() {
		Response<List<Usuario>> response = new Response<>();
		List<Usuario> usuarios = service.findAll();
		response.setData(usuarios);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	@ApiOperation(value = "FIND BY ID - Recupera informações de um usuário em específico através de seu ID")
	public ResponseEntity<Response<Usuario>> findById(@PathVariable Long id) {
		Response<Usuario> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

	@GetMapping("parameter/{parameter}")
	@ApiOperation(value = "FIND BY PARAMETER - Recupera informações dos usuários cadastrados através de um parâmetro (nome, cpf...)")
	public ResponseEntity<Response<List<Usuario>>> findByParameter(@PathVariable String parameter) {
		Response<List<Usuario>> response = new Response<>();
		response.setData(service.findByParameter(parameter));
		return ResponseEntity.ok(response);
	}

}
