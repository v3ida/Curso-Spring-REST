package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class Endereco {
	
	@Column(name = "endereço_cep")
	private String cep;
	
	@Column(name = "endereço_logradouro")
	private String logradouro;
	
	@Column(name = "endereço_numero")
	private String numero;
	
	@Column(name = "endereço_complemento")
	private String complemento;
	
	@Column(name = "endereço_bairro")
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;

}
