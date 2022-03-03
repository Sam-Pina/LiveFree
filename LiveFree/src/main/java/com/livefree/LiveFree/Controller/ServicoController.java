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
import org.springframework.web.bind.annotation.RestController;

import com.livefree.LiveFree.Model.Servico;
import com.livefree.LiveFree.Repository.ServicoRepository;

@RestController
@RequestMapping("/servico")
@CrossOrigin("*")
public class ServicoController {

	
	@Autowired
	private ServicoRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Servico>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("avaliacao/{avaliacao}")
	public ResponseEntity<List<Servico>> GetByDescricao(@PathVariable int avaliacao){
		return ResponseEntity.ok(repository.findAllByAvaliacao(avaliacao));
	}
	
	@PostMapping
    public ResponseEntity<Servico> post (@RequestBody Servico servico){
    	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(servico));
    }
    
     @PutMapping
    public ResponseEntity<Servico> put (@RequestBody Servico servico){
    	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(servico));
    }
    
    @DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		repository.deleteById(id);
	}
	 
}
