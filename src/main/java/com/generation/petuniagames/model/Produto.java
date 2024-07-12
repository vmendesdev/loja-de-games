package com.generation.petuniagames.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Nome é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo Nome deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo Descrição é Obrigatório!")
	@Size(min = 5, max = 150, message = "O atributo Descrição deve cconter no mínimo 05 e no máximo 150 caracteres")
	private String descricao;
	
	@NotNull
	@Min(value = 0, message ="O Preço deve ser maior ou igual a zero!")
	private float preco;
	
	@NotNull
	@Min(value = 0, message = "O estoque deve ser maior ou igual a zero!")
	private int estoque;

	//Getters and Setters
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
