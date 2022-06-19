package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cidade;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>  { // REPOSITÓRIO QUE AGREGA CLASSES RELACIONADAS A COZINHA SEM ESPECIFICAÇÃO DE MÉTODOS DE PERSISTÊNCIA
	// List<Cidade> listar();
	// List<Cidade> consultarPorNome(String nome);
	// Cidade buscar(Long id);
	// void remover(Long id);
	// Cidade adicionar(Cidade cidade);
}
