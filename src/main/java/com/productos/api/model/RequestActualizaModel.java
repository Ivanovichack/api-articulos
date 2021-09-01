package com.productos.api.model;

import javax.validation.constraints.NotNull;

public class RequestActualizaModel {
	@NotNull
	private String idArticulo;
	@NotNull
	private String descripcion;
	@NotNull
	private String modelo;
	
	public String getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
