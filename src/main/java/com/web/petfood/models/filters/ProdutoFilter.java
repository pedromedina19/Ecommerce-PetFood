package com.web.petfood.models.filters;

import com.web.petfood.models.Categoria;

public class ProdutoFilter {

	private Long id;
	private String nome;
	private String descricao;
	private Float menorPreco;
	private Float maiorPreco;
	private Categoria categoria;
	private Long codigomarca;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Float getMenorPreco() {
		return menorPreco;
	}
	public void setMenorPreco(Float menorPreco) {
		this.menorPreco = menorPreco;
	}
	public Float getMaiorPreco() {
		return maiorPreco;
	}
	public void setMaiorPreco(Float maiorPreco) {
		this.maiorPreco = maiorPreco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Long getCodigomarca() {
		return codigomarca;
	}
	public void setCodigomarca(Long codigomarca) {
		this.codigomarca = codigomarca;
	}

	@Override
	public String toString() {
		return "ProdutoFilter [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", menorPreco=" + menorPreco
				+ ", maiorPreco=" + maiorPreco + ", categoria=" + categoria + ", codigomarca=" + codigomarca + "]";
	}




}