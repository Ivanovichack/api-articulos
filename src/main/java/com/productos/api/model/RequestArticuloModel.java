package com.productos.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequestArticuloModel {
	
	@NotNull
	@Size(min = 1)
	@NotEmpty
	private List<String> ids;
	
	public RequestArticuloModel() {
		if(ids == null) {ids = new ArrayList<>();}
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
}
