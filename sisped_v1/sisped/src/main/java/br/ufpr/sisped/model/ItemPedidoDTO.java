package br.ufpr.sisped.model;

import java.io.Serializable;

public class ItemPedidoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idpedido;
	private Long idproduto;
	private Long qtdade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Long idpedido) {
		this.idpedido = idpedido;
	}
	public Long getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}
	public Long getQtdade() {
		return qtdade;
	}
	public void setQtdade(Long qtdade) {
		this.qtdade = qtdade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ItemPedidoDTO(Long id, Long idpedido, Long idproduto, Long qtdade) {
		super();
		this.id = id;
		this.idpedido = idpedido;
		this.idproduto = idproduto;
		this.qtdade = qtdade;
	}
	
	
	  public ItemPedidoDTO() { 
		  super();
	  
	  }
	 

}
