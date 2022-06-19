package com.algaworks.algafood.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.FormaPagamento;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> { // REPOSITÓRIO QUE AGREGA CLASSES RELACIONADAS A COZINHA SEM ESPECIFICAÇÃO DE MÉTODOS DE PERSISTÊNCIA
	// List<FormaPagamento> listar();
	// FormaPagamento buscar(Long id);
	// void remover(FormaPagamento formaPagamento);
	// FormaPagamento adicionar(FormaPagamento formaPagamento); 
}
