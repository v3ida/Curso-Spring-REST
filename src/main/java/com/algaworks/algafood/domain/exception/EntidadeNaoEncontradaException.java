package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// CLASSE DE EXCEPTION REFATORADA COM A ANOTAÇÃO RESPONSESTATUS
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entidade não encontrada")
public abstract class EntidadeNaoEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public EntidadeNaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }   
}


