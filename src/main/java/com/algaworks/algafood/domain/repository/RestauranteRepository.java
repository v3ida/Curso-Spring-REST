package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository 
	extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
	JpaSpecificationExecutor<Restaurante> { 
	
	// List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	// QUERY CUSTOMIZADA QUE USA COMO PARAMETRO A TAXA DE FRETE ENTRE A INICIAL E A FINAL
	
	// List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
	// QUERY CUSTOMIZADA QUE CONSULTA POR NOME E RECEBE O NOME E O 
	
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	int countByCozinhaId(Long cozinha);
	
	public List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, 
			BigDecimal taxaFreteFinal);
}
