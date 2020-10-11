package br.com.dev.desafio.service;

import java.util.List;

import br.com.dev.desafio.entity.Tarefa;


public interface TarefaService {
	
	Tarefa create(Tarefa tarefa);
	
	Tarefa update(Tarefa tarefa);
	
	Tarefa findById(Long id);

	List<Tarefa> findAll();
	
	List<Tarefa> findByProjetoId(Long id);
	
	List<Tarefa> findByTituloContainingIgnoreCase(String titulo);

	void deleteById(Long id);
}
