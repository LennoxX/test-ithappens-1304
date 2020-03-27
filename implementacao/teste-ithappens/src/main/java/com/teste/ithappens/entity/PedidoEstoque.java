package com.teste.ithappens.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.teste.ithappens.enums.TpFormaPagamento;
import com.teste.ithappens.enums.TpTipoPedido;

@Entity
@Table(name = "pedido_estoque")
public class PedidoEstoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TpFormaPagamento tpFormaPagamento;

	@Enumerated(EnumType.STRING)
	private TpTipoPedido tpTipoPedido;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "filial_id")
	private Filial filial;

	@Column(columnDefinition = "TEXT")
	private String observacao;

	private BigDecimal valorTotal;

	private Long totalItens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TpFormaPagamento getTpFormaPagamento() {
		return tpFormaPagamento;
	}

	public void setTpFormaPagamento(TpFormaPagamento tpFormaPagamento) {
		this.tpFormaPagamento = tpFormaPagamento;
	}

	public TpTipoPedido getTpTipoPedido() {
		return tpTipoPedido;
	}

	public void setTpTipoPedido(TpTipoPedido tpTipoPedido) {
		this.tpTipoPedido = tpTipoPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(Long totalItens) {
		this.totalItens = totalItens;
	}

}
