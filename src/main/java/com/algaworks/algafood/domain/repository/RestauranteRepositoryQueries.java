package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries { 
	// CLASSE QUE ARMAZENA OS MÉTODOS DE QUERIES DE RESTAURANTES
	
	public List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
	
	public List<Restaurante> findRestaurantesFreteGratis(String nome);

}