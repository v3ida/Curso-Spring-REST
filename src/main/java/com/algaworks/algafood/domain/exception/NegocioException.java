package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// CLASSE DE EXCEPTION REFATORADA COM A ANOTAÇÃO RESPONSESTATUS
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Entidade não encontrada")
public class NegocioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NegocioException(String mensagem) {
		super(mensagem);
	}
	
	public NegocioException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}