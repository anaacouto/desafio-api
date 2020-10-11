package br.com.dev.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.desafio.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
	boolean existsById(Long id);
	
	boolean existsByTituloContainingIgnoreCaseAndProjetoId(String titulo, Long id);
	
	boolean existsByProjetoId(Long id);
	
	List<Tarefa> findByProjetoId(Long id);
	
	List<Tarefa> findByTituloContainingIgnoreCase(String titulo);
	
	

}
