package com.cabralme.cadastropix.config;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cabralme.cadastropix.entities.Conta;
import com.cabralme.cadastropix.repositories.ContaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ContaRepository contaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Conta c1 = new Conta(UUID.randomUUID(), 35904, 1762, "PF");
		Conta c2 = new Conta(UUID.randomUUID(), 673445, 2870, "PF");
		Conta c3 = new Conta(UUID.randomUUID(), 147284, 4510, "PJ");
		
		contaRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}

	
}
