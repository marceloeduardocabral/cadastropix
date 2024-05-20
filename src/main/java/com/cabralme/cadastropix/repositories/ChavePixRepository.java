package com.cabralme.cadastropix.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabralme.cadastropix.entities.ChavePix;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePix, UUID>{

	List<ChavePix> findByNumeroagenciaAndNumeroconta(Integer agencia, Integer conta);
	List<ChavePix> findByTipochaveContainingIgnoreCase(String tipochave);
	List<ChavePix> findByNomecorrentistaContainingIgnoreCase(String nomecorrentista);
	
	List<ChavePix> findByValorchaveContainingIgnoreCase(String valorchave);
	
}
