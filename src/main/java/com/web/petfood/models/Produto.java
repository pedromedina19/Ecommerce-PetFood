package com.web.petfood.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "obrigatório")
	private String nome;
	@NotBlank(message = "obrigatório")
	@Column(length = 4096)
	private String descricao;
	@NotNull(message = "obrigatório")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	@NotNull(message = "obrigatório")
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	@NotBlank(message = "obrigatório")
	private String nomeImagem;
	@NotNull(message = "obrigatório")
	private Float peso;
	@NotNull(message = "obrigatório")
	private Float valorVenda;
	@NotNull(message = "obrigatório")
	private Float custo;
	@NotNull(message = "obrigatório")
	private Integer quantidadeEstoque;

	public Produto(){
		categoria = Categoria.CAES;
	}

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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}
	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public Float getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Float valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Float getCusto() {
		return custo;
	}
	public void setCusto(Float custo) {
		this.custo = custo;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", categoria=" + categoria
				+ ", status=" + status + ", marca=" + marca + ", nomeImagem=" + nomeImagem + ", peso=" + peso
				+ ", valorVenda=" + valorVenda + ", custo=" + custo + ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}

	

}
