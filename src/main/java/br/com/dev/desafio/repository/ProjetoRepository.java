package br.com.dev.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.desafio.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
	
	boolean existsById(Long id);
	
	boolean existsByTituloContainingIgnoreCase(String titulo);
	
	List<Projeto> findAllByOrderByDataPrevisaoEntregaDesc();

}
