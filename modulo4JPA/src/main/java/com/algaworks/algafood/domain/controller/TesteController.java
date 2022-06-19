package com.algaworks.algafood.domain.controller;

import static com.algaworks.algafood.infrastructure.repository.spec.RestaurantesSpec.restaurantesFreteGratis;
import static com.algaworks.algafood.infrastructure.repository.spec.RestaurantesSpec.restaurantesNomeSemelhante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController // CONTROLADOR REST
@RequestMapping("/teste") // PARA IDENTIFICAR O CAMINHO DAS REQUISIÇÕES WEB
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(String nome) {
		return cozinhaRepository.findTodasByNome(nome);
	}
	
	@GetMapping("/cozinha/unica-por-nome")
	public Optional<Cozinha> cozinhaPorNome(String nome) {
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping("/restaurante/com-frete-gratis")
	public List<Restaurante> restauranteFreteGratis(String nome) {
		
		return restauranteRepository.findAll(restaurantesFreteGratis()
				.and(restaurantesNomeSemelhante(nome)));
	}


}
