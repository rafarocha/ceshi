package br.edu.curso.mockito.exemplo.callback.restaurante;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Ingrediente;
import br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.ItemCardapio;

public class Refeicao {
	
	public Embalagem embalagem;
	public List<Ingrediente> ingredientes;
	
	public Refeicao(List<Ingrediente> ingredientes) {
		this.ingredientes = new ArrayList<Ingrediente>( ingredientes ); 
	}
	
	public Refeicao(ItemCardapio item) {
		this( item.ingredientes );
	}
	
	
	public Ingrediente[] getIngredientes() {
		Ingrediente[] ins = new Ingrediente[ this.total() ];
		return this.ingredientes.toArray( ins );
	}
	
	private int total() {
		return ( CollectionUtils.isEmpty(ingredientes) ) 
				? 0 : ingredientes.size();
	}
	
	enum Embalagem {
		Padrao, Copa;
	}
	
}