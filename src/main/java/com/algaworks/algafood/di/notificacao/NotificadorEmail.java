// CLASSE QUE NOTIFICARÁ AO CLIENTE A ATIVAÇÃO DO CADASTR0
package com.algaworks.algafood.di.notificacao; // nome do pacote

import org.springframework.stereotype.Component;

import com.algaworks.di.modelo.Cliente;

@Component // o Component identifica a classe abaixo como um componente/bean para poder ser gerenciado pelo Spring
public class NotificadorEmail { 
	
	
	public NotificadorEmail() {
		System.out.printf("Construtor\n");
	}

	public void notificar(Cliente cliente, String mensagem) { // método para notificar o cliente, sendo os parâmetros o cliente que irá receber e a mensagem que será enviada 
		System.out.printf("Notificando %s através do email %s: %s\n", // mensagem
				cliente.getNome(), cliente.getEmail(), mensagem); // atributos que serão usados na mensagem
	}

}
