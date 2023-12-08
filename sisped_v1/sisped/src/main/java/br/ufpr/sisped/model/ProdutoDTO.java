package br.ufpr.sisped.model;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ProdutoDTO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public ProdutoDTO() { 
		  super();
	  
	  }

}
