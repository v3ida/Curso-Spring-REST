package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Primary
@Component
public class NotificadorEmail implements Notificador {
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando o cliente " + cliente.getNome() + " através do e-mail " + cliente.getEmail() + ": " + mensagem + "\n");
	}

}
