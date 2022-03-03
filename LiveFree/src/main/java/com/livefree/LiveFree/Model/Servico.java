package com.livefree.LiveFree.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "servico")

public class Servico {
	
	//Campos da model
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size (min = 1, max = 2000)
	private String descricao;
	
	@NotNull
	private double preco;
	
	@NotNull
	private int avaliacao;
	
	@NotNull
	@Size (min = 1, max = 2000)
	private String foto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("servicos")
	private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("servicos")
	private Usuario usuario;
	
	//Getters & Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
}
