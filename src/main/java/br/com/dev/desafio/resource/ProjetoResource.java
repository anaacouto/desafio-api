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
import br.com.dev.desafio.entity.Projeto;
import br.com.dev.desafio.service.ProjetoService;

@RestController
@RequestMapping("/api/projeto")
public class ProjetoResource {
	
	@Autowired
	private ProjetoService service;
	
	@PostMapping
	public ResponseEntity<Response<Projeto>> create(
			@RequestBody Projeto projeto, BindingResult result) {
		Response<Projeto> response = new Response<>();
		try {
			response.setData(service.create(projeto));
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<Response<Projeto>> update(
			@RequestBody Projeto projeto, BindingResult result) {
		Response<Projeto> response = new Response<>();
		try {
			response.setData(service.update(projeto));
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Projeto>> findById(
			@PathVariable("id") Long id) {
		Response<Projeto> response = new Response<>();
		try {
			response.setData(service.findById(id));
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<Projeto>>> findAll() {
		Response<List<Projeto>> response = new Response<>();
		try {
			response.setData(service.findAll());
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
