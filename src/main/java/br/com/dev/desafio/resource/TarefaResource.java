package br.com.dev.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.desafio.dto.Response;
import br.com.dev.desafio.entity.Tarefa;
import br.com.dev.desafio.service.TarefaService;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaResource {
	
	@Autowired
	private TarefaService service;
	
	@PostMapping
	public ResponseEntity<Response<Tarefa>> create(
			@RequestBody Tarefa tarefa, BindingResult result) {
		Response<Tarefa> response = new Response<>();
		try {
			response.setData(service.create(tarefa));
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<Response<Tarefa>> update(
			@RequestBody Tarefa tarefa, BindingResult result) {
		Response<Tarefa> response = new Response<>();
		try {
			response.setData(service.update(tarefa));
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Tarefa>> findById(
			@PathVariable("id") Long id) {
		Response<Tarefa> response = new Response<>();
		try {
			response.setData(service.findById(id));
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<Tarefa>>> findAll() {
		Response<List<Tarefa>> response = new Response<>();
		try {
			response.setData(service.findAll());
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "projeto/{id}")
	public ResponseEntity<Response<List<Tarefa>>> findByProjetoId(@PathVariable("id") Long id) {
		Response<List<Tarefa>> response = new Response<>();
		try {
			response.setData(service.findByProjetoId(id));
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "busca/{titulo}")
	public ResponseEntity<Response<List<Tarefa>>> findByProjetoId(@PathVariable("titulo") String titulo) {
		Response<List<Tarefa>> response = new Response<>();
		try {
			response.setData(service.findByTituloContainingIgnoreCase(titulo));
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Response<String>> deleteById(
			@PathVariable("id") Long id) {
		Response<String> response = new Response<>();
		try {
			service.deleteById(id);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

}
