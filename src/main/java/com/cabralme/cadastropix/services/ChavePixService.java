package com.cabralme.cadastropix.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabralme.cadastropix.entities.ChavePix;
import com.cabralme.cadastropix.entities.Conta;
import com.cabralme.cadastropix.repositories.ChavePixRepository;

@Service
public class ChavePixService {

	@Autowired
	private ChavePixRepository repository;
	
	public List<ChavePix> findAll(){
		return repository.findAll();
	}
	
	public ChavePix findById(UUID id) {
		Optional<ChavePix> conta = repository.findById(id);
		return conta.get();
	}
	
}
