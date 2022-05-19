package com.mjv.ecommercegame.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.ecommercegame.entities.Endereco;
import com.mjv.ecommercegame.repositories.EnderecoRepository;
import com.mjv.ecommercegame.services.excecoes.ResourceNotFoundException;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Endereco insert(Endereco obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Endereco update(Long id, Endereco obj) {
		
		try {
		Endereco entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Endereco entity, Endereco obj) {
	
		entity.setLogradouro(obj.getLogradouro());
		entity.setNumero(obj.getNumero());
		entity.setBairro(obj.getBairro());
		entity.setCep(obj.getCep());
		
	}
}
