package br.edu.curso.mockito.exemplo.spy.basico;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.curso.mockito.exemplo.spy.basico.Order.Item;

/**
 * exemplo adaptado de http://lkrnac.net/blog/2014/01/21/mock-autowired-fields/
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
	
	private static final int TEST_ORDER_ID = 15;
	private static final int TEST_SHOES_PRICE = 2;
	private static final int TEST_SHIRT_PRICE = 1;
	
	@InjectMocks
	private OrderService testingObject;
	
	@Spy
	private PriceService priceService;
	
	@Mock
	private OrderDao orderDao;
	
	@Test
	public void testGetOrderService() {
		Order order = new Order(Arrays.asList(Item.SHOES, Item.SHIRT));
		Mockito.when(orderDao.getOrder(TEST_ORDER_ID)).thenReturn(order);
		
		//notice different Mockito syntax for spy
		Mockito.doReturn(TEST_SHIRT_PRICE).when(priceService).getActualPrice(Item.SHIRT);
		Mockito.doReturn(TEST_SHOES_PRICE).when(priceService).getActualPrice(Item.SHOES);
		
		//call testing method
		int actualOrderPrice = testingObject.getOrderPrice(TEST_ORDER_ID);
		
		Assert.assertEquals(TEST_SHIRT_PRICE + TEST_SHOES_PRICE, actualOrderPrice);
	}
	
}