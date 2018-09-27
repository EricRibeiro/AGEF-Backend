package com.tisv.agef.resources;

import java.net.URI;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.services.PecaService;

@RestController
@RequestMapping(value = "/peca")
public class PecaResource {

	@Autowired
	private PecaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Peca peca = service.find(id);
		return ResponseEntity.ok(peca);
	}
	
	@GetMapping()
	public ResponseEntity<?> findAll() {
		List<Peca> pecas = service.findAll();
		return ResponseEntity.ok(pecas);
	}

	@PostMapping()
	public ResponseEntity<?> insert(@RequestBody Peca pecaArg) {
		Peca peca = service.insert(pecaArg);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(peca.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Peca peca) {
		service.update(id, peca);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		return ResponseEntity.badRequest().body("Existe alguma constraint na entidade sendo utilizada.");
	}
}
