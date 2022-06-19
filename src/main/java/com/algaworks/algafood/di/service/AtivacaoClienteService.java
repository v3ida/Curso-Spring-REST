//CLASSE PARA SIMULAR A ATIVAÇÃO DE CADASTRO DE UM CLIENTE
package com.algaworks.algafood.di.service; // nome do pacote

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService { // nome da classe
		
	@Autowired
	private Notificador notificador;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	
	}

}