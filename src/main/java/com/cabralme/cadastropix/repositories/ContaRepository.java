package com.cabralme.cadastropix.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabralme.cadastropix.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, UUID>{

}
