package com.productos.api.exception;

import java.util.Arrays;

import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.productos.api.common.ConstantesCommon;
import com.productos.api.common.CustomException;
import com.productos.api.model.ExceptionModel;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandler extends ExceptionHandlerExceptionResolver{
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler({ Exception.class })
	public ResponseEntity<ExceptionModel> noDataFoundIntern(Exception ex) {	
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.INTERNAL_SERVER_ERROR.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+HttpStatus.INTERNAL_SERVER_ERROR.value();
		response.setCodigo(codigo);
		response.setMensaje("Error inesperado");
		response.setDetalles(
				Arrays.asList("Error interno en el servidor",ex.getMessage()));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler({ CustomException.class })
	public ResponseEntity<ExceptionModel> noDataFound(CustomException ex) {	
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.NOT_FOUND.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+HttpStatus.NOT_FOUND.value();
		response.setCodigo(codigo);
		response.setMensaje("Recurso no encontrado");
		response.setDetalles(
				Arrays.asList("Recurso no encontrado",ex.getMessage()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<ExceptionModel> methodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
	
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(
				Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID, "El tipo de solicitud HTTP no es valido"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler({ HttpMediaTypeNotSupportedException.class })
	public ResponseEntity<ExceptionModel> notAcceptableMediaTypeHandler(HttpMediaTypeNotSupportedException gtw) {
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler({ MissingRequestHeaderException.class })
	public ResponseEntity<ExceptionModel> MissingRequestHeaderException(MissingRequestHeaderException gtw) {
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionModel> handleAllOtherErrors(HttpMessageNotReadableException ex) {
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				 +HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionModel> handleAllOtherErrors(NullPointerException ex) {
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+ HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionModel> MethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+ HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionModel> ConstraintViolationException(ConstraintViolationException ex) {
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+  HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ExceptionModel> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		ExceptionModel response = new ExceptionModel();
		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+  HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionModel> noHandlerFoundException(NoHandlerFoundException ex) {
		ExceptionModel response = new ExceptionModel();

		String codigo = HttpStatus.BAD_REQUEST.value() + "." + ConstantesCommon.NOMBRE_MEDIO + "."
				+ HttpStatus.BAD_REQUEST.value();
		response.setCodigo(codigo);
		response.setMensaje(ConstantesCommon.MESSAGE_NO_VALID);
		response.setDetalles(
				Arrays.asList(ConstantesCommon.MESSAGE_NO_VALID, "No se ha encontrado la ruta o path solicitado"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
