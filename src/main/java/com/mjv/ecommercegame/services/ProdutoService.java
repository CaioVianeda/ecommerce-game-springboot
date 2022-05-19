package com.mjv.ecommercegame.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.ecommercegame.entities.Endereco;
import com.mjv.ecommercegame.entities.Produto;
import com.mjv.ecommercegame.repositories.ProdutoRepository;
import com.mjv.ecommercegame.services.excecoes.ResourceNotFoundException;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Produto insert(Produto obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Produto update(Long id, Produto obj) {
		
		try {
		Produto entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Produto entity, Produto obj) {
		
		entity.setDescricao(obj.getDescricao());
		entity.setPlataforma(obj.getPlataforma());
		entity.setValor(obj.getValor());
		
	}
}
