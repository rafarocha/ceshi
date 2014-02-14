package com.rocha.curso.ceshi.refactoring.generictype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.rocha.curso.ceshi.refactoring.generictype.People.JSON;
import com.rocha.curso.ceshi.refactoring.generictype.People.Product;

public class TransformerTest {
	
	private Transformer trans;
	
	@Test public void jsonToProduct() throws IOException {
		Product product = trans.toProduct( JSON.product.extract() );
		
		assertEquals( product.name, "Banana" );
		assertEquals( product.id, "123" );
		assertTrue( product.price == 23.00 );
	}
	
	@Test public void jsonToPeople() throws IOException {
		People people = trans.toPeople( JSON.people.extract()  );
		checar( people);
	}
	
	@Test public void jsonToOrder() throws IOException {
		Order order = trans.toOrder( JSON.order.extract()  );
		
		assertTrue( order.number == 123 );
		assertTrue( order.total == 500 );
		checar( order.client );
	}
	
	private void checar(People people) {
		assertEquals( people.name , "Anderson Silva");
		assertTrue( people.age == 39 );
	}
	
	@Before public void before() {
		this.trans = new Transformer();
	}
	
}