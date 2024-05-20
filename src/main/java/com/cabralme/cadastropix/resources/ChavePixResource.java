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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cabralme.cadastropix.entities.ChavePix;
import com.cabralme.cadastropix.services.ChavePixService;

@RestController
@RequestMapping(value = "/chavespix")
public class ChavePixResource {

	@Autowired
	private ChavePixService service;
	
	@GetMapping
	public ResponseEntity<List<ChavePix>> findAll(){
		List<ChavePix> contas = service.findAll();
		return ResponseEntity.ok().body(contas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChavePix> findById(@PathVariable UUID id){
		ChavePix conta = service.findById(id);
		return ResponseEntity.ok().body(conta);
	}
	
	@GetMapping(value = "/consulta/agenciaeconta")
	public ResponseEntity<List<ChavePix>> findByNumeroagenciaAndNumeroconta(
			@RequestParam(name = "agencia") Integer agencia,
			@RequestParam(name = "conta") Integer conta)
	{
		List<ChavePix> chaves = service.findByNumeroagenciaAndNumeroconta(agencia, conta);
		return ResponseEntity.ok().body(chaves);
	}
	
	@GetMapping(value = "/consulta/tipochave/{tipochave}")
	public ResponseEntity<List<ChavePix>> findByTipochaveContainingIgnoreCase(@PathVariable String tipochave){
		List<ChavePix> chaves = service.findByTipochaveContainingIgnoreCase(tipochave);
		return ResponseEntity.ok().body(chaves);
	}
	
	@GetMapping(value = "/consulta/nome/{nome}")
	public ResponseEntity<List<ChavePix>> findByNomecorrentistaContainingIgnoreCase(@PathVariable String nome){
		List<ChavePix> chaves = service.findByNomecorrentistaContainingIgnoreCase(nome);
		return ResponseEntity.ok().body(chaves);
	}
	
	@GetMapping(value = "/consulta/valorchave/{valor}")
	public ResponseEntity<List<ChavePix>> findByValorchaveContainingIgnoreCase(@PathVariable String valor){
		List<ChavePix> chaves = service.findByValorchaveContainingIgnoreCase(valor);
		return ResponseEntity.ok().body(chaves);
	}
	
	
	@PostMapping
	public ResponseEntity<ChavePix> insert(@RequestBody ChavePix chave){
		chave = service.insert(chave);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(chave.getId()).toUri();
		return ResponseEntity.created(uri).body(chave);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ChavePix> update(@PathVariable UUID id, @RequestBody ChavePix chave){
		chave = service.update(id, chave);
		return ResponseEntity.ok().body(chave);
	}
}
