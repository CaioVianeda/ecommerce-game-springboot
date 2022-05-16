package com.mjv.ecommercegame.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private String telefone; 
	private String email;
	private String senha;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	


	public Cliente() {
		
	}

	public Cliente(Long id, String name, String cpf, String telefone, String email, String senha, Endereco endereco) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email
				+ ", senha=" + senha + ", endereco=" + endereco + "]";
	}
	
	
	
}
