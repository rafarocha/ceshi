package br.edu.curso.faq.clone.proposta;

import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

public class CloneTest {
	
	@Test public void clonePedido() throws CloneNotSupportedException {
		Pedido pedido = this.cria();
		Pedido clone = (Pedido) pedido.cloneRecomendado();
		assertThat( clone, not(is(pedido)) );
	}
	
	private Pedido cria() {
		Pedido pedido = new Pedido();
		pedido.id = 1;
		pedido.data = new Date();
		pedido.cliente = new Cliente(9);
		
		List<ItemPedido> itens = Lists.newArrayList();
		pedido.itens = itens;
		for (int i = 1; i < 2; i++) {
			pedido.add( new Produto(), 1 );
		}
		return pedido;
	}

	class Pedido implements Cloneable {
		public List<ItemPedido> itens;
		public Cliente cliente;
		public Date data;
		public Integer id;
		
		public Pedido add(Produto prod, int qtde) {
			int id = this.itens.size() + 1;
			this.itens.add( new ItemPedido(id, prod, qtde) );
			return this;
		}
		
		@Deprecated @Override protected Object clone() throws CloneNotSupportedException {
			Pedido pedido = (Pedido) super.clone();
			pedido.cliente = this.cliente;
			pedido.data = this.data;
			pedido.id = null;
			return pedido;
		}
		
		public Pedido cloneRecomendado() {
			Pedido pedido = new Pedido();
			pedido.cliente = this.cliente;
			pedido.itens = Lists.newArrayList();
			if ( CollectionUtils.isNotEmpty(this.itens) ) {
				for (ItemPedido item : this.itens) {
					ItemPedido itemNovo = new ItemPedido(null, item.produto, item.quantidade);
					pedido.itens.add( itemNovo ); // composicao cria anulando o id por ser composicao!
				}				
			}
			return pedido;
		}
		@Override public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass() ) {
				return false;
			}
			
			final Pedido pedido = (Pedido) obj;
			if ( pedido.id == this.id ) return true;
			if ( isEmpty(pedido.itens) || isEmpty(this.itens) ) return false;
			for (ItemPedido item : this.itens) {
				if ( !pedido.itens.contains(item) ) 
					return false;
			}
			return true; 
		}
	}
	
	class ItemPedido {
		public Integer id;
		public Produto produto;
		public int quantidade;
		public ItemPedido(Integer id, Produto prod, int qtde) {
			this.id = id;
			this.produto = prod;
			this.quantidade = qtde;
		}
		@Override public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass() ) {
				return false;
			}
			final ItemPedido item = (ItemPedido) obj;
			return Objects.equal( this.id, item.id ); 
		}
	}
	
	class Produto {}
	class Cliente {
		public Integer id;
		public Cliente(int id) {
			this.id = id;
		}
	}

}