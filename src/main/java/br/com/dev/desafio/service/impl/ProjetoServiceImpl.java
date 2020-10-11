package br.com.dev.desafio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.dev.desafio.entity.Projeto;
import br.com.dev.desafio.exception.CustomException;
import br.com.dev.desafio.repository.ProjetoRepository;
import br.com.dev.desafio.repository.TarefaRepository;
import br.com.dev.desafio.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService {
	
	@Autowired
	private ProjetoRepository repository;
	
	@Autowired
	private TarefaRepository tarefaRepository;

	@Override
	public Projeto create(Projeto projeto) {
		
		if (projeto.getId() != null && repository.existsById(projeto.getId()))
			throw new CustomException("Id de projeto já utilizado.", HttpStatus.BAD_REQUEST);
		if (repository.existsByTituloContainingIgnoreCase(projeto.getTitulo()))
			throw new CustomException("Título de projeto já utilizado.", HttpStatus.BAD_REQUEST);
		
		return repository.save(projeto);
	}

	@Override
	public Projeto update(Projeto projeto) {
		
		if (!repository.existsById(projeto.getId()))
			throw new CustomException("Não existe um projeto com esse ID.", HttpStatus.BAD_REQUEST);
		
		return repository.save(projeto);
	}

	@Override
	public Projeto findById(Long id) {
		
		if (id == null)
			throw new CustomException("Informe o ID.", HttpStatus.BAD_REQUEST);
		
		Optional<Projeto> projeto = repository.findById(id);
		if (projeto.isPresent()) {
			return projeto.get();
		} else {
			throw new CustomException("Não há projeto com o ID informado.", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<Projeto> findAll() {
		return repository.findAllByOrderByDataPrevisaoEntregaDesc();
	}
	
	public void deleteById(Long id) {
		if (tarefaRepository.existsByProjetoId(id))
			throw new CustomException("Não é possível deletar um projeto que já tem tarefas.", HttpStatus.BAD_REQUEST);
		repository.deleteById(id);
	}
	
}
