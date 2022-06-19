package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.algaworks.algafood.domain.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> { // REPOSITÓRIO QUE AGREGA CLASSES RELACIONADAS A COZINHA SEM ESPECIFICAÇÃO DE MÉTODOS DE PERSISTÊNCIA
	void remover(Long id);
	// List<Estado> listar();
	// Estado buscar(Long id);
	// void remover(Estado estado);
	// Estado adicionar(Estado estado); 
}
