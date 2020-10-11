package br.com.dev.desafio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.dev.desafio.entity.Tarefa;
import br.com.dev.desafio.exception.CustomException;
import br.com.dev.desafio.repository.TarefaRepository;
import br.com.dev.desafio.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {
	
	@Autowired
	private TarefaRepository repository;

	@Override
	public Tarefa create(Tarefa tarefa) {
		if (tarefa.getId() != null && repository.existsById(tarefa.getId()))
			throw new CustomException("Id de tarefa já utilizado.", HttpStatus.BAD_REQUEST);
		if (repository.existsByTituloContainingIgnoreCaseAndProjetoId(tarefa.getTitulo(), tarefa.getProjeto().getId()))
			throw new CustomException("Título de tarefa já utilizado.", HttpStatus.BAD_REQUEST);
		
		tarefa.setStatus(false);
		return repository.save(tarefa);
	}

	@Override
	public Tarefa update(Tarefa tarefa) {
		if (!repository.existsById(tarefa.getId()))
			throw new CustomException("Não existe uma tarefa com esse ID.", HttpStatus.BAD_REQUEST);
		
		return repository.save(tarefa);
	}

	@Override
	public Tarefa findById(Long id) {
		if (id == null)
			throw new CustomException("Informe o ID.", HttpStatus.BAD_REQUEST);
		
		Optional<Tarefa> tarefa = repository.findById(id);
		if (tarefa.isPresent()) {
			return tarefa.get();
		} else {
			throw new CustomException("Não há tarefa com o ID informado.", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<Tarefa> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Tarefa> findByProjetoId(Long id) {
		return repository.findByProjetoId(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public List<Tarefa> findByTituloContainingIgnoreCase(String titulo) {
		if (titulo.length() <= 2)
			throw new CustomException("Termo de busca muito pequeno.", HttpStatus.BAD_REQUEST);
		return repository.findByTituloContainingIgnoreCase(titulo);
	}
	
	

}
