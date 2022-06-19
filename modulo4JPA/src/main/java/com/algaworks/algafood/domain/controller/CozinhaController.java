package com.algaworks.algafood.domain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@Controller 
// IDENTIFICAÇÃO DA CLASSE COMO UM COMPONENTE SPRING DO TIPO CONTROLADOR
@ResponseBody 
// INDICA QUE AS REQUISIÇÕES FEITAS PARA O MÉTODO ABAIXO DEVEM SER A RESPOSTA DA REQUISIÇÃO HTTP
@RequestMapping("/cozinhas") 
// MAPEIA AS REQUISIÇÕES RECEBIDAS PELO CONTROLADOR
// A ANOTAÇÃO @RestController SUBSTITUI AS ANOTAÇÕES @Controller E @@ResponseBody
public class CozinhaController { 
// CLASSE QUE IRÁ CONTROLAR AS COZINHAS	
	
	@Autowired
	private CozinhaRepository cozinhaRepository; 
	// INSTANCIAÇÃO DE UM OBJETO DA CLASSE COZINHA REPOSITORY
	
	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	
	@GetMapping 
	// MAPEIA AS REQUISIÇÕES GET E TRAZ PARA ESTE MÉTODO
	// MEDIATYPE ESPECIFICA OS FORMATOS DISPONIVEIS PARA EXIBIR A APLICAÇÃO
	public List<Cozinha> listar() { 
	// MÉTODO QUE IRÁ LISTAR AS COZINHAS
		return cozinhaRepository.findAll(); 
		// RETORNANDO A LISTA DE COZINHAS
	}
	// LISTA OS OBJETOS
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) { 
		Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
		
		if (cozinha.isPresent()) {
			return ResponseEntity.ok(cozinha.get());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
	}
	// BUSCA OBJETOS POR ID E RETORNA STATUS 404 PARA COZINHAS NÃO ENCONTRADAS
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	// ADICIONA UM NOVO OBJETO COM POST
	
	@PutMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> atualizar(@PathVariable Long cozinhaId,
			@RequestBody Cozinha cozinha) {
		
		Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);
		
		if (cozinhaAtual.isPresent()) {
		BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");
		
		Cozinha cozinhaSalva = cadastroCozinhaService.adicionar(cozinhaAtual.get());
		return ResponseEntity.ok(cozinhaSalva);
	}
		
	return ResponseEntity.notFound().build();

	}
	// ATUALIZA/ALTERA UM OBJETO COM O PUT
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
		try {
			cadastroCozinhaService.excluir(cozinhaId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
				return ResponseEntity.notFound().build();
				
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	// REMOVE OBJETOS
}