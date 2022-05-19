package com.mjv.ecommercegame.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mjv.ecommercegame.entities.Pagamento;
import com.mjv.ecommercegame.entities.Pedido;
import com.mjv.ecommercegame.entities.enums.StatusPedido;
import com.mjv.ecommercegame.services.PagamentoService;
import com.mjv.ecommercegame.services.PedidoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentosResource {
	
	@Autowired
	private PagamentoService service;
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> findAll(){
		
		List<Pagamento> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pagamento> findById(@PathVariable Long id){
		Pagamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/pendentes")
	public ResponseEntity<List<Pedido>> findPendente(){
		List<Pedido> list = new ArrayList<>();
		for(Pedido x : pedidoService.findAll()) {
			if((x.getStatusPedido() == StatusPedido.AGUARDANDO_PAGAMENTO)) {
				list.add(x);
			}
		}
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Pagamento> insert(@PathVariable Long id){
		
		Pedido pedido = pedidoService.findById(id);
		pedido.setStatusPedido(StatusPedido.PAGO);
		Pagamento pagamento = new Pagamento(null,pedido);
		pedido.setPagamento(pagamento);
		
		Pagamento obj = service.insert(pagamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody Pagamento obj){
		
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
