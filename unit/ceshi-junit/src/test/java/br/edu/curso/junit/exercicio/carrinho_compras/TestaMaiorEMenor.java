package br.edu.curso.junit.exercicio.carrinho_compras;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestaMaiorEMenor {

	private CarrinhoDeCompras carrinho; 
	private MaiorEMenor algoritmo;
	
	private Produto geladeira;
	private Produto liquidificador;
	private Produto jogoPratos;
	
	@Before public void before() {
		this.carrinho = new CarrinhoDeCompras();		
		this.algoritmo = new MaiorEMenor();
		this.fabricarProdutos();
	}
	
	@Test public void ordemDecrescente() {
		this.carrinho.adiciona( geladeira, liquidificador, jogoPratos );
		this.algoritmo.encontra(carrinho);
		this.checarMaiorMenor( geladeira, jogoPratos );
	}

	@Test public void ordemCrescente() {
		this.carrinho.adiciona( jogoPratos, liquidificador, geladeira );
		this.algoritmo.encontra(carrinho);
		this.checarMaiorMenor( geladeira, jogoPratos );
	}

	@Test public void unicoProduto() {
		this.carrinho.adiciona( jogoPratos );
		this.algoritmo.encontra(carrinho);
		this.checarMaiorMenor( jogoPratos, jogoPratos );
	}
	
	private void checarMaiorMenor(Produto maior, Produto menor) {
		assertEquals( maior, algoritmo.getMaior() );
		assertEquals( menor, algoritmo.getMenor() );	
	}

	private void fabricarProdutos() {
		this.geladeira = new Produto("Geladeira", 450.0);
		this.liquidificador = new Produto("Liquidificador", 250.0);
		this.jogoPratos = new Produto("Jogo de Pratos", 70.0);
	}
	
}