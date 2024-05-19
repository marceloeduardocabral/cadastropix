package com.cabralme.cadastropix.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cabralme.cadastropix.entities.Conta;
import com.cabralme.cadastropix.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> contas = service.findAll();
		return ResponseEntity.ok().body(contas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable UUID id){
		Conta conta = service.findById(id);
		return ResponseEntity.ok().body(conta);
	}
	
	@PostMapping
	public ResponseEntity<Conta> insert(@RequestBody Conta conta){
		conta = service.insert(conta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).body(conta);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Conta> update(@PathVariable UUID id, @RequestBody Conta conta){
		conta = service.update(id, conta);
		return ResponseEntity.ok().body(conta);
	}
	
}
