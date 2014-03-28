package br.edu.curso.junit.exercicio.carrinho_compras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class CarrinhoDeCompras {

	private List<Item> itens;

	public CarrinhoDeCompras() {
		this.itens = new ArrayList<Item>();
	}

	public void adiciona(Item item) {
		this.itens.add(item);
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void adiciona(Produto produto) {
		this.adiciona( new Item(produto, 1) );
	}

	public List<Produto> getProdutos() {
		List<Produto> produtos = Lists.newArrayList();
		for (Item item : itens) {
			produtos.add( item.getProduto() );
		}
		return produtos;
		
	}

}