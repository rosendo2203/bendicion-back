package com.tienda.bendicion.model;

public class DetalleVenta {
	
	private String id;
	private String codigodetalleventa;
	private Integer cantidadproducto;
	private String codigoproducto;
	private String codigoventa;
	private Double valoriva;
	private Double valortotal;
	private Double valorventa;
	
	
	public DetalleVenta(
			String codigodetalleventa,
			Integer cantidadproducto, 
			String codigoproducto,
			String codigoventa, 
			Double valortotal, 
			Double valorventa, 
			Double valoriva) {
		super();
		this.codigodetalleventa = codigodetalleventa;
		this.cantidadproducto = cantidadproducto;
		this.codigoproducto = codigoproducto;
		this.codigoventa = codigoventa;
		this.valortotal = valortotal;
		this.valorventa = valorventa;
		this.valoriva = valoriva;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigodetalleventa() {
		return codigodetalleventa;
	}
	public void setCodigodetalleventa(String codigodetalleventa) {
		this.codigodetalleventa = codigodetalleventa;
	}
	public Integer getCantidadproducto() {
		return cantidadproducto;
	}
	public void setCantidadproducto(Integer cantidadproducto) {
		this.cantidadproducto = cantidadproducto;
	}
	public String getCodigoproducto() {
		return codigoproducto;
	}
	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}
	public String getCodigoventa() {
		return codigoventa;
	}
	public void setCodigoventa(String codigoventa) {
		this.codigoventa = codigoventa;
	}
	public Double getValortotal() {
		return valortotal;
	}
	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}
	public Double getValorventa() {
		return valorventa;
	}
	public void setValorventa(Double valorventa) {
		this.valorventa = valorventa;
	}
	public Double getValoriva() {
		return valoriva;
	}
	public void setValoriva(Double valoriva) {
		this.valoriva = valoriva;
	}
	
}
