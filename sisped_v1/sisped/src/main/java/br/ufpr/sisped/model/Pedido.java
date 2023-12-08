package br.ufpr.sisped.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data", nullable = false)
	private Date data;
	
	@Column(name = "idcliente", nullable = false)
	private Long idcliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pedido(Long id, Date data, Long idcliente) {
		super();
		this.id = id;
		this.data = data;
		this.idcliente = idcliente;
	}
	
	public Pedido() { 
		  super();
	  
	  }

}
