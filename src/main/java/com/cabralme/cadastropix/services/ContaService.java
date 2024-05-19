package com.cabralme.cadastropix.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabralme.cadastropix.entities.Conta;
import com.cabralme.cadastropix.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	public List<Conta> findAll(){
		return repository.findAll();
	}
	
	public Conta findById(UUID id) {
		Optional<Conta> conta = repository.findById(id);
		return conta.get();
	}
	
}
