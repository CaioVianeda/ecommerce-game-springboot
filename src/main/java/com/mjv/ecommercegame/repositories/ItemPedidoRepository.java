package com.mjv.ecommercegame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjv.ecommercegame.entities.ItemPedido;
import com.mjv.ecommercegame.entities.pk.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

}
