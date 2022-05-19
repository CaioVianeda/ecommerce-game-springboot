package com.mjv.ecommercegame.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.ecommercegame.entities.Cliente;
import com.mjv.ecommercegame.entities.Endereco;
import com.mjv.ecommercegame.services.ClienteService;
import com.mjv.ecommercegame.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll(){
		
		List<Cliente> list = service.findAll(); 
		List<Endereco> enderecos = new ArrayList<>();	
		for(Cliente x : list) {
			enderecos.add(x.getEndereco());
		}
		return ResponseEntity.ok().body(enderecos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getEndereco());
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> insert(@PathVariable Long id, @RequestBody Endereco obj){		
		Endereco endereco = enderecoService.update(id, obj);
		return ResponseEntity.ok().body(endereco);
	}
}
