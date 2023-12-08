package br.ufpr.sisped.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itempedido")
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "idpedido", nullable = false)
	private Long idpedido;
	
	@Column(name = "idproduto", nullable = false)
	private Long idproduto;
	
	@Column(name = "qtdade", nullable = false)
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

	public ItemPedido(Long id, Long idpedido, Long idproduto, Long qtdade) {
		super();
		this.id = id;
		this.idpedido = idpedido;
		this.idproduto = idproduto;
		this.qtdade = qtdade;
	}
	
	
	  public ItemPedido() { 
		  super();
	  
	  }
	 

}
