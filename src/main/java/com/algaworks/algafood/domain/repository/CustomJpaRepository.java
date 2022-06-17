package com.algaworks.algafood.domain.repository;

import java.util.Optional;


import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomJpaRepository<T, ID>  {

	Optional<T> buscarPrimeiro(); 

}
