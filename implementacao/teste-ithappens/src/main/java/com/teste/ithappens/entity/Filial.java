package com.teste.ithappens.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "filial", uniqueConstraints = @UniqueConstraint(columnNames = "codigo", name = "codigo_uk"))
public class Filial {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_filial")
	@SequenceGenerator(name = "seq_filial", allocationSize = 1, sequenceName = "seq_filial")
	private Long id;

	private Long codigo;

	private String bairro;

	private String municipio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

}
