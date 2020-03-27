package com.teste.ithappens.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.teste.ithappens.enums.TpStatusItemPedido;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pedido_estoque_id")
	@NotNull(message = "ATENÇÃO! CAMPO pedidoEstoque É OBRIGATÓRIO")
	private PedidoEstoque pedidoEstoque;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@Enumerated(EnumType.STRING)
	private TpStatusItemPedido status;

	@NotNull(message = "ATENÇÃO! CAMPO quantidade É OBRIGATÓRIO")
	@Min(value = 1, message = "ATENÇÃO! O CAMPO quantidade PRECISA SER MAIOR DO QUE ZERO")
	private Long quantidade;

	private BigDecimal valorUnitario;

	private BigDecimal valorTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PedidoEstoque getPedidoEstoque() {
		return pedidoEstoque;
	}

	public void setPedidoEstoque(PedidoEstoque pedidoEstoque) {
		this.pedidoEstoque = pedidoEstoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public TpStatusItemPedido getStatus() {
		return status;
	}

	public void setStatus(TpStatusItemPedido status) {
		this.status = status;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
