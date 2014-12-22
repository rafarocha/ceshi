package br.edu.curso.junit.exercicio.carrinho_compras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class CarrinhoDeCompras {

	private static final int UMA_UNIDADE = 1;
	private List<Item> itens;

	public CarrinhoDeCompras() {
		this.itens = new ArrayList<Item>();
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void adiciona(Produto ... produtos) {
		for (Produto produto : produtos) {
			this.itens.add( new Item(produto, UMA_UNIDADE) );
		}
	}

	public List<Produto> getProdutos() {
		List<Produto> produtos = Lists.newArrayList();
		for (Item item : itens) {
			produtos.add( item.getProduto() );
		}
		return produtos;
	}

}