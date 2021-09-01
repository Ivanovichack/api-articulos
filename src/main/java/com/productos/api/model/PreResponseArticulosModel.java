package com.productos.api.model;

import java.util.ArrayList;
import java.util.List;

public class PreResponseArticulosModel {
	private List<ArticuloModel> articulos = new ArrayList<>();

	public List<ArticuloModel> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<ArticuloModel> articulos) {
		this.articulos = articulos;
	}
	
	
}
