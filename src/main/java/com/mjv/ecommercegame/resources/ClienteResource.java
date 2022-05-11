package com.mjv.ecommercegame.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.ecommercegame.entities.Cliente;
import com.mjv.ecommercegame.model.Endereco;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@GetMapping
	public ResponseEntity<Cliente> findAll(){
		Endereco endereco = new Endereco("Rua Badi do Carmo Mesquita", "6", "Praia de Leste", "83255-000");
		Cliente c = new Cliente(1L, "Caio", "122.875.409-87", "(41)98420-6429", "caio.vianwda@gmail.com","gghh125690", endereco );
		return ResponseEntity.ok().body(c);
	}
}
