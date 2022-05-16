package com.mjv.ecommercegame.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.ecommercegame.entities.Endereco;
import com.mjv.ecommercegame.repositories.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> obj =  repository.findById(id);
		return obj.get();
	}
}
