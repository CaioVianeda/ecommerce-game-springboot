package com.mjv.ecommercegame.entities.enums;

public enum Plataforma {
	
	PLAYSTATION(1),
	XBOX360(2),
	XBOXONE(3),
	NINTENDO(4),
	PC(5);
	
	private int codigo;
	
	private Plataforma(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static Plataforma valueOf(int codigo) {
		
		for( Plataforma x : Plataforma.values()) {
			if( x.getCodigo() == codigo) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código de Status Inválido");
	}
}
