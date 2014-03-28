package br.edu.curso.mockito.exemplo.spy.basico;

public class OrderService {
	
	private PriceService priceService;
	private OrderDao orderDao;

	public int getOrderPrice(int orderId){
		Order order = orderDao.getOrder(orderId);
		return priceService.calculatePriceForOrder(order);
	}

}