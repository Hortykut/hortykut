package com.github.hortykut.hortykut.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Este campo é obrigatório")
	private String titulo;

	@NotNull(message = "Este campo é obrigatório")
	private double valor;

	@NotBlank(message = "Este campo é obrigatorio")
	private String responsavel;

	@NotBlank(message = "Este campo é obrigatorio")
	private String descricao;

	private String foto;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Produto() {
	}

	public Produto(Long id, String titulo, double valor, String responsavel, String descricao, Categoria categoria,
			Usuario usuario, String foto) {
		this.id = id;
		this.titulo = titulo;
		this.valor = valor;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.categoria = categoria;
		this.usuario = usuario;
		this.foto = foto;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
