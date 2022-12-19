package com.web.petfood.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "marca")
public class Marca implements Serializable{

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @Column(length = 1024)
    private String descricao;
    @NotBlank(message = "obrigatória")
    private String imagem;

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
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    @Override
    public String toString() {
        return "Marca [id=" + id + ", status=" + status + ", nome=" + nome + ", descricao=" + descricao + ", imagem="
                + imagem + "]";
    }

    
}
