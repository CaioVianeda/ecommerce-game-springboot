package com.mjv.ecommercegame.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mjv.ecommercegame.entities.Cliente;
import com.mjv.ecommercegame.entities.Endereco;
import com.mjv.ecommercegame.entities.ItemPedido;
import com.mjv.ecommercegame.entities.Pagamento;
import com.mjv.ecommercegame.entities.Pedido;
import com.mjv.ecommercegame.entities.Produto;
import com.mjv.ecommercegame.entities.enums.Plataforma;
import com.mjv.ecommercegame.entities.enums.StatusPedido;
import com.mjv.ecommercegame.repositories.ClienteRepository;
import com.mjv.ecommercegame.repositories.ItemPedidoRepository;
import com.mjv.ecommercegame.repositories.PedidoRepository;
import com.mjv.ecommercegame.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
//	@Autowired
//	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Produto pr1 = new Produto(null,150.00,"God of War",Plataforma.PLAYSTATION);
		Produto pr2 = new Produto(null,300.00,"The Last of Us",Plataforma.PLAYSTATION);
		Produto pr3 = new Produto(null,80.00,"Horizon Zero Dawn",Plataforma.PC);
		produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3));
		
		Endereco endereco = new Endereco(null,"Rua Badi do Carmo Mesquita", "6", "Praia de Leste", "83255-000");
		Endereco endereco2 = new Endereco(null,"Alameda Jorge Lacerda", "454", "Canoas", "83255-000");
		List<Endereco> enderecos1 = new ArrayList<>();
		List<Endereco> enderecos2 = new ArrayList<>();
		enderecos1.add(endereco);
		enderecos2.add(endereco2);
		
		
		Cliente c1 = new Cliente(null, "Caio", "122.875.409-87", "(41)98420-6429", "caio.vianwda@gmail.com","gghh125690", endereco);
		Cliente c2 = new Cliente(null, "Monalisa", "122.721.875-00", "(41)98420-6429", "monalisa@gmail.com","gghh125690", endereco2);
		
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		
		Pedido p1 = new Pedido(null, Instant.parse("2022-06-20T21:53:07Z"), StatusPedido.PAGO,c1);
		Pedido p2 = new Pedido(null, Instant.parse("2022-08-20T21:35:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c2);
		Pedido p3 = new Pedido(null, Instant.parse("2022-07-20T21:28:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c1);
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		ItemPedido ip1 = new ItemPedido(p1, pr3, 2, pr3.getValor());
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1));
		
		Pagamento pagamento = new Pagamento(null,  Instant.parse("2022-06-21T21:53:07Z"), p1);
		p1.setPagamento(pagamento);
		pedidoRepository.save(p1);
	}
	
}
