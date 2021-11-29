package com.tienda.bendicion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ventas")
public class Venta {
	
	//atributos en privado para la encapsulacion
	
	@Id
	private String id;
	private Integer codigoventa;
	private Integer cedulacliente;
	private String usernameusuario;	
	private Double ivaventa;
	private Double totalventa;
	private Double valorventa;
	
	public Venta(
			Integer codigoventa, 
			Integer cedulacliente, 
			String usernameusuario, 
			Double ivaventa, 
			Double totalventa,
			Double valorventa) {
		super();
		this.codigoventa = codigoventa;
		this.cedulacliente = cedulacliente;
		this.usernameusuario = usernameusuario;
		this.ivaventa = ivaventa;
		this.totalventa = totalventa;
		this.valorventa = valorventa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCodigoventa() {
		return codigoventa;
	}

	public void setCodigoventa(Integer codigoventa) {
		this.codigoventa = codigoventa;
	}

	public Integer getCedulacliente() {
		return cedulacliente;
	}

	public void setCedulacliente(Integer cedulacliente) {
		this.cedulacliente = cedulacliente;
	}

	public String getUsernameusuario() {
		return usernameusuario;
	}

	public void setUsernameusuario(String usernameusuario) {
		this.usernameusuario = usernameusuario;
	}

	public Double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(Double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public Double getTotalventa() {
		return totalventa;
	}

	public void setTotalventa(Double totalventa) {
		this.totalventa = totalventa;
	}

	public Double getValorventa() {
		return valorventa;
	}

	public void setValorventa(Double valorventa) {
		this.valorventa = valorventa;
	}
	
}
