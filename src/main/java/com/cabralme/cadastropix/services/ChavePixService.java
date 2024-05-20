package com.cabralme.cadastropix.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cabralme.cadastropix.entities.ChavePix;
import com.cabralme.cadastropix.repositories.ChavePixRepository;
import com.cabralme.cadastropix.services.exceptions.DatabaseException;
import com.cabralme.cadastropix.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	
	public ChavePix insert(ChavePix chave) {
		return repository.save(chave);
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
	
	public ChavePix update(UUID id, ChavePix chave) {
		try {
			ChavePix entity = repository.getReferenceById(id);
			updateData( entity, chave);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(ChavePix entity, ChavePix chave) {
		entity.setNomecorrentista(chave.getNomecorrentista());
		entity.setSobrenomecorrentista(chave.getSobrenomecorrentista());
		entity.setNumeroagencia(chave.getNumeroagencia());
		entity.setNumeroconta(chave.getNumeroconta());
		entity.setTipoconta(chave.getTipoconta());
	}
	
	public List<ChavePix> findByNumeroagenciaAndNumeroconta(Integer numeroagencia, Integer numeroconta){
		return repository.findByNumeroagenciaAndNumeroconta(numeroagencia, numeroconta);
	}
	
	public List<ChavePix> findByTipochaveContainingIgnoreCase(String tipo){
		return repository.findByTipochaveContainingIgnoreCase(tipo);
	}
	
	public List<ChavePix> findByNomecorrentistaContainingIgnoreCase(String nome){
		return repository.findByNomecorrentistaContainingIgnoreCase(nome);
	}
	
	public List<ChavePix> findByValorchaveContainingIgnoreCase(String valorchave){
		return repository.findByValorchaveContainingIgnoreCase(valorchave);
	}
	
	
}
