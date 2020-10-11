package br.com.dev.desafio.service;

import java.util.List;

import br.com.dev.desafio.entity.Projeto;

public interface ProjetoService {
	
	Projeto create(Projeto projeto);
	
	Projeto update(Projeto projeto);
	
	Projeto findById(Long id);

	List<Projeto> findAll();
	
	void deleteById(Long id);

}
