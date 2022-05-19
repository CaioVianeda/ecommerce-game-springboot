package com.mjv.ecommercegame.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjv.ecommercegame.entities.enums.Plataforma;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valor;
	private String descricao;
	private Integer plataforma;
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> items = new HashSet<>();
	
	public Produto() {
		
	}

	public Produto(Long id, Double valor, String descricao, Plataforma plataforma) {
		super();
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
		setPlataforma(plataforma);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	public Plataforma getPlataforma() {
		return Plataforma.valueOf(plataforma);
	}

	public void setPlataforma(Plataforma plataforma) {
		if(plataforma != null)
		this.plataforma = plataforma.getCodigo();
	}

	@JsonIgnore
	public Set<Pedido> getPedidos(){
		Set<Pedido> set = new HashSet<>();
		
		for(ItemPedido x : items) {
			set.add(x.getPedido());
		}
		
		return set;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	

}
