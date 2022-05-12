package com.mjv.ecommercegame.entities.enums;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(3),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static StatusPedido valueOf(int codigo) {
		
		for( StatusPedido x : StatusPedido.values()) {
			if( x.getCodigo() == codigo) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código de Status Inválido");
	}
}
