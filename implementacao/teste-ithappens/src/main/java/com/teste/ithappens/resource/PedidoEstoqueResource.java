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
import com.teste.ithappens.enums.TpFormaPagamento;
import com.teste.ithappens.service.PedidoEstoqueService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pedidoEstoque")
@CrossOrigin("*")
public class PedidoEstoqueResource {

	@Autowired
	private PedidoEstoqueService service;

	@PostMapping
	@ApiOperation(value = "CREATE - Criar um novo PedidoEstoque")
	public ResponseEntity<Response<PedidoEstoque>> create(@RequestBody PedidoEstoque pedidoEstoque) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.create(pedidoEstoque));
		return ResponseEntity.ok().body(response);

	}
	
	@PostMapping("{idPedidoEstoque}/adicionar-item")
	@ApiOperation(value = "ADD ITEM - Adiciona um ItemPedido a um PedidoEstoque existente")
	public ResponseEntity<Response<PedidoEstoque>> addItem(@PathVariable Long idPedidoEstoque, @RequestBody ItemPedido itemPedido) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.addItem(itemPedido, idPedidoEstoque));
		return ResponseEntity.ok().body(response);

	}
	
	@PostMapping("remover-item/{idItemPedido}")
	@ApiOperation(value = "REMOVER ITEM - Remove um ItemPedido de um PedidoEstoque existente")
	public ResponseEntity<Response<PedidoEstoque>> removeItem(@PathVariable Long idItemPedido) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.removeItem(idItemPedido));
		return ResponseEntity.ok().body(response);

	}
	
	@PostMapping("{idPedidoEstoque}/processar")
	@ApiOperation(value = "PROCESSAR - Processa um PedidoEstoque informando a forma de pagamento. Responsável por atualizar os estoques dos produtos")
	public ResponseEntity<Response<PedidoEstoque>> processar(@PathVariable Long idPedidoEstoque, @RequestBody TpFormaPagamento tpFormaPagamento) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.processar(idPedidoEstoque, tpFormaPagamento));
		return ResponseEntity.ok().body(response);

	}

	@PutMapping
	@ApiOperation(value = "UPDATE - Atualiza um PedidoEstoque existente")
	public ResponseEntity<Response<PedidoEstoque>> update(@RequestBody PedidoEstoque pedidoEstoque) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.update(pedidoEstoque));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping("{id}")
	@ApiOperation(value = "FIND BY ID - Recupera informações de um PedidoEstoque em específico através de seu ID")
	public ResponseEntity<Response<PedidoEstoque>> findById(@PathVariable Long id) {
		Response<PedidoEstoque> response = new Response<>();
		response.setData(service.findById(id));
		return ResponseEntity.ok(response);
	}

}
