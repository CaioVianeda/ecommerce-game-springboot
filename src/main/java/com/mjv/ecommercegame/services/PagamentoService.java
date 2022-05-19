package com.mjv.ecommercegame.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.ecommercegame.entities.Pagamento;
import com.mjv.ecommercegame.repositories.PagamentoRepository;
import com.mjv.ecommercegame.services.excecoes.ResourceNotFoundException;


@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repository;
	
	public List<Pagamento> findAll(){
		return repository.findAll();
	}
	
	public Pagamento findById(Long id) {
		Optional<Pagamento> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Pagamento insert(Pagamento obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Pagamento update(Long id, Pagamento obj) {
		
		try {
		Pagamento entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Pagamento entity, Pagamento obj) {
		
//		entity.setDescricao(obj.getDescricao());
//		entity.setPlataforma(obj.getPlataforma());
//		entity.setValor(obj.getValor());
		
	}
}
