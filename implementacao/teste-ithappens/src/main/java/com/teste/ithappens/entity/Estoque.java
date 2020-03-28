package com.teste.ithappens.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estoque")
	@SequenceGenerator(name = "seq_estoque", allocationSize = 1, sequenceName = "seq_estoque")
	private Long id;

	@JoinColumn(name = "produto_id")
	@ManyToOne
	private Produto produto;

	private Long quantidade;

	@JoinColumn(name = "filial_id")
	@ManyToOne
	private Filial filial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

}
