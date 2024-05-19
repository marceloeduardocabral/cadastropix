package com.cabralme.cadastropix.resources;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabralme.cadastropix.entities.Conta;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

	@GetMapping
	public ResponseEntity<Conta> findAll(){
		Conta obj = new Conta(UUID.randomUUID(), 1762, 35904, "PF");
		return ResponseEntity.ok().body(obj);
	}
}
