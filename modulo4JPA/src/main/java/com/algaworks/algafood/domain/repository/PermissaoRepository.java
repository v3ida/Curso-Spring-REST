package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository { // REPOSITÓRIO QUE AGREGA CLASSES RELACIONADAS A COZINHA SEM ESPECIFICAÇÃO DE MÉTODOS DE PERSISTÊNCIA
	List<Permissao> listar();
	Permissao buscar(Long id);
	void remover(Permissao permissao);
	Permissao adicionar(Permissao permissao); 
}
