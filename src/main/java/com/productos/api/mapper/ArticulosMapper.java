package com.productos.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.productos.api.model.ArticuloModel;

public class ArticulosMapper implements RowMapper<ArticuloModel>{

	@Override
	public ArticuloModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArticuloModel articulo = new ArticuloModel();
		articulo.setDescripcion(rs.getString("descripcion"));
		articulo.setId(rs.getString("id"));
		articulo.setModelo(rs.getString("modelo"));
		articulo.setPrecio(rs.getFloat("precio"));
		articulo.setNombre(rs.getString("nombre"));
		return articulo;
	}
	
}
