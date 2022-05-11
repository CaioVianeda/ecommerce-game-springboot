package com.mjv.ecommercegame.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mjv.ecommercegame.entities.Cliente;
import com.mjv.ecommercegame.model.Endereco;
import com.mjv.ecommercegame.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Endereco endereco = new Endereco("Rua Badi do Carmo Mesquita", "6", "Praia de Leste", "83255-000");
		Cliente c1 = new Cliente(null, "Caio", "122.875.409-87", "(41)98420-6429", "caio.vianwda@gmail.com","gghh125690", endereco);
		Cliente c2 = new Cliente(null, "Monalisa", "122.721.875-00", "(41)98420-6429", "monalisa@gmail.com","gghh125690", endereco);
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
	}
	
}
