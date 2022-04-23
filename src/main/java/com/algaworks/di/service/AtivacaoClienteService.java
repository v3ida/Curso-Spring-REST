//CLASSE PARA SIMULAR A ATIVAÇÃO DE CADASTRO DE UM CLIENTE
package com.algaworks.di.service; // nome do pacote

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.notificacao.NotificadorEmail;
import com.algaworks.di.modelo.Cliente; // importação da classe Cliente

@Component
public class AtivacaoClienteService { // nome da classe
	
	private NotificadorEmail notificador; // atributo associado à interface

	public void ativar(Cliente cliente) { // método para ativar o cliente que recebe um Cliente como atributo
		cliente.ativar(); // método que altera a propriedade "ativo" na classe Cliente para true
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
		
	}

}
