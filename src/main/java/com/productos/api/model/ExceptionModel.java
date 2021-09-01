package com.productos.api.model;

import java.util.ArrayList;
import java.util.List;

public class ExceptionModel {
	private String codigo;
	private String mensaje;
	private List<String> detalles;
	
	public ExceptionModel() {
		if(detalles == null) detalles = new ArrayList<>();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<String> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<String> detalles) {
		this.detalles = detalles;
	}
	
	
	
}
