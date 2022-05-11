package com.mjv.ecommercegame.entities;

import java.io.Serializable;
import java.util.Objects;

import com.mjv.ecommercegame.model.Endereco;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String cpf;
	private String telefone; 
	private String email;
	private String senha;
	private Endereco endereco;
	
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	
	
	
}
