package br.edu.curso.junit.exercicio.carrinho_compras;

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

}