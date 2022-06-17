package com.algaworks.algafood.infrastructure.repository.spec;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Restaurante;

public class RestaurantesSpec {
	
	public static Specification<Restaurante> restaurantesFreteGratis() {
		return (root, query, builder) ->
		 builder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
	}
	
	public static Specification<Restaurante> restaurantesNomeSemelhante(String nome) {
		return (root, query, builder) ->
			builder.like(root.get("nome"), "%" + nome + "%");
	}
}

// OBS: OS METODOS IMPLEMENTADOS NESSA CLASSE "FÁBRICA" FORAM DEFINIDOS NA CLASSE DE CONTROLE