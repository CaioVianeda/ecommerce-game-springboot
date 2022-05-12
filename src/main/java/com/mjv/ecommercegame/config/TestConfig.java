package com.mjv.ecommercegame.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mjv.ecommercegame.entities.Cliente;
import com.mjv.ecommercegame.entities.Pedido;
import com.mjv.ecommercegame.entities.enums.StatusPedido;
import com.mjv.ecommercegame.model.Endereco;
import com.mjv.ecommercegame.repositories.ClienteRepository;
import com.mjv.ecommercegame.repositories.PedidoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Endereco endereco = new Endereco("Rua Badi do Carmo Mesquita", "6", "Praia de Leste", "83255-000");
		Cliente c1 = new Cliente(null, "Caio", "122.875.409-87", "(41)98420-6429", "caio.vianwda@gmail.com","gghh125690", endereco);
		Cliente c2 = new Cliente(null, "Monalisa", "122.721.875-00", "(41)98420-6429", "monalisa@gmail.com","gghh125690", endereco);
		
		Pedido p1 = new Pedido(null, Instant.parse("2022-06-20T21:53:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c1);
		Pedido p2 = new Pedido(null, Instant.parse("2022-08-20T21:35:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c2);
		Pedido p3 = new Pedido(null, Instant.parse("2022-07-20T21:28:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c1);
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
	
}
