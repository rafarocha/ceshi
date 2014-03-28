package br.edu.curso.junit.exemplo.asserts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BaskaraTest {
	
	private Baskara baskara = new Baskara();
	
	@Test public void deltaRaizExata() {
		int a = 4, b = 5, c = 1;
		Double delta = baskara.delta(a, b, c);
		assertEquals( Double.valueOf(3), delta );
	}
	
	@Test public void deltaRaizNaoExata() {
		int a = 1, b = 4, c = 2;
		Double delta = baskara.delta(a, b, c);
		assertEquals( Double.valueOf(2.8284271247461903), delta );
	}
	
	@Test public void deltaRaizNegativaNaN() {
		int a = 4, b = 1, c = 1;
		Double delta = baskara.delta(a, b, c);		
		assertEquals( Double.valueOf(Double.NaN), delta );
	}
	
	@Test public void deltaRaizZero() {
		int a = 4, b = 4, c = 1;
		Double delta = baskara.delta(a, b, c);		
		assertThat( Double.valueOf(0), is(delta) );
	}
	
	class Baskara {
		public Double delta(int a, int b, int c) {
			int calc = ( b * b ) - ( 4 * a * c );
			Double raiz = Math.sqrt( calc );
			System.out.println( raiz );
			return raiz;
		}
	}

}