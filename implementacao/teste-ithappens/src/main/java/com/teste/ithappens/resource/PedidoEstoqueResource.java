package com.teste.ithappens.resource;

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
import com.teste.ithappens.entity.PedidoEstoque;
import com.teste.ithappens.service.PedidoEstoqueService;

@RestController
@RequestMapping("/api/pedidoEstoque")
@CrossOrigin("*")
public class PedidoEstoqueResource {

	@Autowired
	private PedidoEstoqueService service;

	@PostMapping
	public ResponseEntity<Response<PedidoEstoque>> create(@RequestBody PedidoEstoque pedidoEstoque) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.create(pedidoEstoque));
		return ResponseEntity.ok().body(response);

	}
	
	@PostMapping("{idPedidoEstoque}/adicionar-item")
	public ResponseEntity<Response<PedidoEstoque>> addItem(@PathVariable Long idPedidoEstoque, @RequestBody ItemPedido itemPedido) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.addItem(itemPedido, idPedidoEstoque));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	public ResponseEntity<Response<PedidoEstoque>> update(@RequestBody PedidoEstoque pedidoEstoque) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.update(pedidoEstoque));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping("{id}")
	public ResponseEntity<Response<PedidoEstoque>> findById(@PathVariable Long id) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

}
