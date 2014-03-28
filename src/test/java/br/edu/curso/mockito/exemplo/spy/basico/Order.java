package br.edu.curso.mockito.exemplo.spy.basico;

import java.util.Collection;
import java.util.Collections;

public class Order {
	
	private Collection<Item> items;

	public Order(Collection<Item> items) {
		this.items = items;
	}

	public Collection<Item> getItems(){
		return Collections.unmodifiableCollection(items);
	}
	
	enum Item {
		SHOES, SHIRT;
	}

}