package br.edu.curso.junit.exemplo.asserts;

import org.apache.commons.lang.NotImplementedException;
import org.junit.Ignore;
import org.junit.Test;

/**
 * baskara
 * a 	b 	c
 * 4	5	1	deltaRaizExata 
 * 1	4	2	deltaRaizNaoExata 
 * 4	1	1	deltaRaizNegativaNaN
 * 4	4	1	deltaRaizZero
 * 
 * então pede-se para criar os criar casos de testes
 *
 */
public class BaskaraTest {
	
	private Baskara baskara = new Baskara();
	
	@Test @Ignore public void deltaRaizExata() {
		throw new NotImplementedException();
	}
	
	@Test @Ignore public void deltaRaizNaoExata() {
		throw new NotImplementedException();
	}
	
	@Test @Ignore public void deltaRaizNegativaNaN() {
		throw new NotImplementedException();
	}
	
	@Test @Ignore public void deltaRaizZero() {
		throw new NotImplementedException();
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