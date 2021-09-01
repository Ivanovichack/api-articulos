package com.productos.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productos.api.common.CustomException;
import com.productos.api.model.PreResponseArticulosModel;
import com.productos.api.model.RequestActualizaModel;
import com.productos.api.model.RequestArticuloModel;
import com.productos.api.model.ResponseOK;
import com.productos.api.service.ArticuloService;

@Validated
@RestController
@RequestMapping("/catalogo")
public class ArticulosController {

	@Autowired
	private ArticuloService service;

	@GetMapping("/detalles")
	public ResponseEntity<Object> getDetalleArticulo(@Valid @RequestBody(required = true) RequestArticuloModel requests) throws CustomException {		
		PreResponseArticulosModel articulos = service.getDetallesArticulos(requests.getIds());
		ResponseOK response = new ResponseOK();
		response.setCodigo("200.sistemas-productos.100200");
		response.setMensaje("Operación exitosa.");
		response.setResultado(articulos);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PutMapping("/actualiza")
	public ResponseEntity<Object> updateDetalleArticulo(@Valid @RequestBody(required = true) RequestActualizaModel request) throws Exception{
		service.updateDetalleArticulo(request);
		ResponseOK response = new ResponseOK();
		response.setCodigo("201.sistemas-productos.100201");
		response.setMensaje("Actualizado correctamente");
		response.setResultado(request.getIdArticulo() + " actualizado correctamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
}
