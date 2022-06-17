package com.algaworks.algafood.domain.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

import lombok.Data;

@Service
@Data
public class CadastroEstadoService {

	private static final String MSG_ESTADO_EM_USO = "Estado de código %d não pode ser removido, pois está em uso";
	private static final String MSG_ESTADO_NAO_ENCONTRADO = "Não existe um cadastro de estado com código %d";
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado adicionar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(
				String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_ESTADO_EM_USO, estadoId));
		}
	}
	public Estado buscarOuFalhar (Long estadoId) {
		return estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EstadoNaoEncontradoException(
						String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId)));
	}
}