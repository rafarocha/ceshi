package br.edu.curso.junit.exercicio.carrinho_compras;

import com.google.common.base.Objects;

public class Produto {
	
	private String nome;
	private double valor;

	public Produto(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}
	
	@Override public boolean equals(Object obj) {
		if ( obj == null && !(obj instanceof Produto) )
			return false;
		
		Produto produto = (Produto) obj;
		return Objects.equal(this.nome, produto.nome);
	}
	
}