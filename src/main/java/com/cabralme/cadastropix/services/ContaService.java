package com.cabralme.cadastropix.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cabralme.cadastropix.entities.Conta;
import com.cabralme.cadastropix.repositories.ContaRepository;
import com.cabralme.cadastropix.services.exceptions.DatabaseException;
import com.cabralme.cadastropix.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	public List<Conta> findAll(){
		return repository.findAll();			
	}
	
	public Conta findById(UUID id) {
		Optional<Conta> conta = repository.findById(id);		
		return conta.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Conta insert(Conta conta) {
		return repository.save(conta);
	}
	
	public void delete(UUID id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}		
	}
	
	public Conta update(UUID id, Conta conta) {
		try {
			Conta entity = repository.getReferenceById(id);
			updateData( entity, conta);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Conta entity, Conta conta) {
		entity.setNumeroagencia(conta.getNumeroagencia());		
		entity.setNumeroconta(conta.getNumeroconta());
		entity.setTipopessoaconta(conta.getTipopessoaconta());
	}
	
}
