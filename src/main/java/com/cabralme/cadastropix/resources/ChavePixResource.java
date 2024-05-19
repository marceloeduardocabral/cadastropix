package com.cabralme.cadastropix.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
