package com.gengaming.lojagames.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo nome é obrigatório!")
	private String nome;
	
	private String descricao;
	
	@NotNull(message = "Informar o tipo de console é obrigatório!")
	private String console;
	
	private int quantidade;
	
	
	private String foto;

	@NotNull(message = "Informar o preço do produto é obrigatório!")
	private BigDecimal preco;
	
	@Column(name = "data_lancamento")
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}


	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
