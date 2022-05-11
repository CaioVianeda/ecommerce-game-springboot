package com.mjv.ecommercegame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjv.ecommercegame.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
