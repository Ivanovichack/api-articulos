package com.productos.api.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.productos.api.common.CustomException;
import com.productos.api.mapper.ArticulosMapper;
import com.productos.api.model.ArticuloModel;
import com.productos.api.model.RequestActualizaModel;

@Component
public class ArticuloDao {

	@Autowired
	@Qualifier("Firstjdbc")
	private JdbcTemplate jdbcTemplate;
	
	public List<ArticuloModel> getDetallesArticulos(List<String> idArticulos) throws CustomException {
		String inParams = String.join(",", idArticulos.stream().map(id -> "'"+id+"'").collect(Collectors.toList()));		
		List<ArticuloModel> articulos = jdbcTemplate.query(String.format("SELECT * FROM detalles WHERE id IN (%s)", inParams), new ArticulosMapper());
		
		if(articulos == null || articulos.isEmpty()) {
			throw new CustomException("No existe información para los ids" + idArticulos.toString());
		}
				
		return articulos;
	}
	
	public void updateDetallesArticulos(RequestActualizaModel request) throws CustomException {		
		
		String query = "UPDATE detalles SET descripcion = ?, modelo = ? WHERE id = ?";
		try {
			int aff = jdbcTemplate.update(query, request.getDescripcion(), request.getModelo(), request.getIdArticulo());
			if (aff == 0) {
				throw new CustomException("No existe la información proporcionada");
			}
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
		
		
		
	}
}
