package com.teste.ithappens.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.teste.ithappens.entity.ItemPedido;
import com.teste.ithappens.service.ItemPedidoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/itemPedido")
@CrossOrigin("*")
public class ItemPedidoResource {

	@Autowired
	private ItemPedidoService service;

	@PostMapping
	@ApiOperation(value = "CREATE - Criar um novo ItemPedido")
	public ResponseEntity<Response<ItemPedido>> create(@RequestBody ItemPedido itemPedido) {
		Response<ItemPedido> response = new Response<>();
		response.setData(service.create(itemPedido));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	@ApiOperation(value = "UPDATE - Atualiza um ItemPedido existente")
	public ResponseEntity<Response<ItemPedido>> update(@RequestBody ItemPedido itemPedido) {
		Response<ItemPedido> response = new Response<>();
		response.setData(service.update(itemPedido));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping("{id}")
	@ApiOperation(value = "FIND BY ID - Recupera informações de um ItemPedido em específico através de seu ID")
	public ResponseEntity<Response<ItemPedido>> findById(@PathVariable Long id) {
		Response<ItemPedido> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

	@GetMapping("pedido-estoque/{id}")
	@ApiOperation(value = "FIND BY ID - Recupera os itens de um pedido através do id do PedidoEstoque ")
	public ResponseEntity<Response<List<ItemPedido>>> findByPedidoEstoqueId(@PathVariable Long id) {
		Response<List<ItemPedido>> response = new Response<>();
		response.setData(service.findByPedidoEstoqueId(id));
		return ResponseEntity.ok(response);
	}

}
