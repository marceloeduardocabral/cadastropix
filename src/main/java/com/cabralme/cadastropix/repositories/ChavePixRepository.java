package com.cabralme.cadastropix.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabralme.cadastropix.entities.ChavePix;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePix, UUID>{

}
