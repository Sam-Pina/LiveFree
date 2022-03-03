package com.livefree.LiveFree.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livefree.LiveFree.Model.Categoria;
import com.livefree.LiveFree.Repository.CategoriaRepository;
import com.livefree.LiveFree.util.EAtendimento;
import com.livefree.LiveFree.util.ECategoria;
import com.livefree.LiveFree.util.EMotivo;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

//	@GetMapping("nomeCategoria/{nomeCategoria}")
//	public ResponseEntity<List<Categoria>> GetByNomeCategoria(@PathVariable String nomeCategoria){
//		return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
//	}

	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria nomeCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nomeCategoria));
	}

	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Categoria>> search(
			@RequestParam(defaultValue = "") ECategoria categoria,
			@RequestParam(defaultValue = "") EAtendimento atendimento,
			@RequestParam(defaultValue = "") EMotivo motivo) {

		if (categoria == null && atendimento == null && motivo == null) {
			return ResponseEntity.ok(repository.findAll());
		}

		if (categoria != null && atendimento != null && motivo != null) {
			return ResponseEntity
					.ok(repository.findAllByCategoriaAndAtendimentoAndMotivo(categoria, atendimento, motivo));
		}

		if (categoria == null && atendimento != null && motivo != null) {
			return ResponseEntity.ok(repository.findAllByAtendimentoAndMotivo(atendimento, motivo));
		}
		
		if (categoria != null && atendimento == null && motivo != null) {
			return ResponseEntity.ok(repository.findAllByCategoriaAndMotivo(categoria, motivo));
		}
		
		if (categoria != null && atendimento != null && motivo == null) {
			return ResponseEntity.ok(repository.findAllByCategoriaAndAtendimento(categoria, atendimento));
		}
		
		if (categoria != null && atendimento == null && motivo == null) {
			return ResponseEntity.ok(repository.findAllByCategoria(categoria));
		}
		
		if (categoria == null && atendimento != null && motivo == null) {
			return ResponseEntity.ok(repository.findAllByAtendimento(atendimento));
		}
		
		if (categoria == null && atendimento == null && motivo != null) {
			return ResponseEntity.ok(repository.findAllByMotivo(motivo));
		}
		
		return null;
		
		

	}
}
