package com.cabralme.cadastropix.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabralme.cadastropix.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, UUID>{

}
