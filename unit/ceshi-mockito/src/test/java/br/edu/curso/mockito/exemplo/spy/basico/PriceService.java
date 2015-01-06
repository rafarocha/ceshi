package br.edu.curso.mockito.exemplo.spy.basico;

import br.edu.curso.mockito.exemplo.spy.basico.Order.Item;

public class PriceService {
	
	public int getActualPrice(Item item){
		throw new UnsupportedOperationException("Fail is not mocked!");
	}

	public int calculatePriceForOrder(Order order){
		int orderPrice = 0;
		for (Item item : order.getItems()){
			orderPrice += getActualPrice(item);
		}
		return orderPrice;
	}

}