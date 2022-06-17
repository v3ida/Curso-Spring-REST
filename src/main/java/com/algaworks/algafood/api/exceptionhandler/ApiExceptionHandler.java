//package com.algaworks.algafood.api.exceptionhandler;
//
//import java.net.http.HttpHeaders;
//import java.time.LocalDateTime;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
//import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
//import com.algaworks.algafood.domain.exception.NegocioException;
//
//@ControllerAdvice
//public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
//	
//	@ExceptionHandler(EntidadeNaoEncontradaException.class)
//	public ResponseEntity<?> handleEntidadeNaoEncontradaException (
//			EntidadeNaoEncontradaException ex, WebRequest request ) {
//		
//		HttpStatus status = HttpStatus.NOT_FOUND; // DEFININDO O STATUS
//		String detail = ex.getMessage(); // DEFININDO A MENSAGEM DE DETALHAMENTO
//		
//		// Problem
//		
//		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), 
//				HttpStatus.CONFLICT, request);
//	}
//	
//	@ExceptionHandler(EntidadeEmUsoException.class)
//	public ResponseEntity<?> handleEntidadeEmUsoException(
//			EntidadeEmUsoException ex, WebRequest request) {
//		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), 
//				HttpStatus.CONFLICT, request);
//	}
//	
//	@ExceptionHandler(NegocioException.class)
//	public ResponseEntity<?> handleNegocioException(
//			NegocioException ex, WebRequest request) {
//		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(),
//				HttpStatus.CONFLICT, request);
//	}
//	
//	protected ResponseEntity<Object> handleExceptionInternal(
//			Exception ex, 
//			Object body, 
//			HttpHeaders headers,
//			HttpStatus status, 
//			WebRequest request) {
//		return super.handleExceptionInternal(ex, body, headers, status, request);
//	}
//	// METODO HANDLEEXCEPTIONINTERNAL
//}
