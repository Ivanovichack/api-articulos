package com.productos.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.api.common.CustomException;
import com.productos.api.dao.ArticuloDao;
import com.productos.api.model.ArticuloModel;
import com.productos.api.model.PreResponseArticulosModel;
import com.productos.api.model.RequestActualizaModel;

@Service
public class ArticuloService {
	
	@Autowired
	private ArticuloDao articuloDao;
	
	
	public PreResponseArticulosModel getDetallesArticulos(List<String> idArticulos) throws CustomException{
		List<ArticuloModel> articulos = articuloDao.getDetallesArticulos(idArticulos);
		articulos.stream().forEach(e -> System.out.println(e.getDescripcion()));
		PreResponseArticulosModel response = new PreResponseArticulosModel();
		response.setArticulos(articulos);
		
		return response;
	}
	
	public void updateDetalleArticulo(RequestActualizaModel request) throws Exception {
		articuloDao.updateDetallesArticulos(request);
	}
	
}
