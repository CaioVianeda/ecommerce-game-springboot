package com.mjv.ecommercegame.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mjv.ecommercegame.entities.Cliente;
import com.mjv.ecommercegame.entities.Endereco;
import com.mjv.ecommercegame.entities.ItemPedido;
import com.mjv.ecommercegame.entities.Pedido;
import com.mjv.ecommercegame.entities.Produto;
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
		
		Produto pr1 = new Produto(null,200.00,"Alexa1");
		Produto pr2 = new Produto(null,300.00,"Alexa2");
		Produto pr3 = new Produto(null,400.00,"Alexa3");
		produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3));
		
		Endereco endereco = new Endereco(null,"Rua Badi do Carmo Mesquita", "6", "Praia de Leste", "83255-000");
		Endereco endereco2 = new Endereco(null,"Alameda Jorge Lacerda", "454", "Canoas", "83255-000");
		
		
		Cliente c1 = new Cliente(null, "Caio", "122.875.409-87", "(41)98420-6429", "caio.vianwda@gmail.com","gghh125690", endereco);
		Cliente c2 = new Cliente(null, "Monalisa", "122.721.875-00", "(41)98420-6429", "monalisa@gmail.com","gghh125690", endereco2);
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		
		Pedido p1 = new Pedido(null, Instant.parse("2022-06-20T21:53:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c1);
		Pedido p2 = new Pedido(null, Instant.parse("2022-08-20T21:35:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c2);
		Pedido p3 = new Pedido(null, Instant.parse("2022-07-20T21:28:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c1);
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		ItemPedido ip1 = new ItemPedido(p1, pr3, 2, pr3.getValor());
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1));
		
	}
	
}
