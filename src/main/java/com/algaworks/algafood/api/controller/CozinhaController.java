package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	// IMPLEMENTAÇÃO DO MÉTODO DE BUSCA SIMPLIFICADO
	@GetMapping("/{cozinhaId}")
	public Cozinha buscar(@PathVariable Long cozinhaId) { 
		return cadastroCozinhaService.buscarOuFalhar(cozinhaId);
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
	public Cozinha atualizar(@PathVariable Long cozinhaId,
			@RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cadastroCozinhaService.buscarOuFalhar(cozinhaId);
	
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		
		return cadastroCozinhaService.adicionar(cozinhaAtual);
	}
		
	// ATUALIZA/ALTERA UM OBJETO COM O PUT
	
	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cozinhaId) {
		cadastroCozinhaService.excluir(cozinhaId);
	}
	// REMOVE OBJETOS
}