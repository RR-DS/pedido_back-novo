package br.ufpr.sisped.model;

import java.io.Serializable;
import java.util.Date;

public class PedidoDTO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date data;
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
	public PedidoDTO(Long id, Date data, Long idcliente) {
		super();
		this.id = id;
		this.data = data;
		this.idcliente = idcliente;
	}
	
	public PedidoDTO() { 
		  super();
	  
	  }
	

}
