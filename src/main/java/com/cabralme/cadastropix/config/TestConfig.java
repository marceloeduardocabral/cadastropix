package com.cabralme.cadastropix.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cabralme.cadastropix.entities.ChavePix;
import com.cabralme.cadastropix.entities.Conta;
import com.cabralme.cadastropix.repositories.ChavePixRepository;
import com.cabralme.cadastropix.repositories.ContaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ChavePixRepository chavepixRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Conta c1 = new Conta(null, 35904, 1762, "PF");
		Conta c2 = new Conta(null, 673445, 2870, "PF");
		Conta c3 = new Conta(null, 147284, 4510, "PJ");
		
		Instant t = Instant.now();
				
		ChavePix key1 = new ChavePix(null, "cpf", "11817059831", "corrente", 1762,
				35904, "Marcelo", "Cabral", t , null, c1);
		ChavePix key2 = new ChavePix(null, "telefone", "+55011949906349", "poupança", 2870,
				147284, "Carlos", "Silva", t, null, c2);
		ChavePix key3 = new ChavePix(null, "email", "cabralme@gmail.com", "corrente", 4510,
				147284, "Ana", "Maria", t, null, c3);
						
		contaRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		chavepixRepository.saveAll(Arrays.asList(key1, key2, key3));
		
	}

	
}
