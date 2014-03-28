package br.edu.curso.junit.exercicio.carrinho_compras;

public class Item {

	private Produto produto;
	private int quantidade;

	public Item(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return this.produto.getValor() * this.quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}