package br.edu.curso.junit.exemplo.asserts;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * delta 
 * a 	b 	c
 * 4	5	1	exata 
 * 1	4	2	naoExata 
 * 4	1	1	negativaNaN
 * 4	4	1	zero
 * 
 * então pede-se 
 * 
 * 1. criar os casos de testes para delta para entradas acima
 * 2. refatorar o codigo, inclusive o nome do teste
 * 3. vamos criar agora a formula oficial de baskara e os testes
 * 4. crie um metodo em baskara que diz se a possuem raizes reais
 */
public class BaskaraTest {
	
	private Baskara baskara;
	
	@Before public void before() {
		this.baskara = new Baskara();
	}
	
	@Test public void delta451Retorna9() {
		double resultado = this.baskara.delta(4, 5 ,1);
		assertTrue( 9.0 == resultado );
	}

	@Test public void delta142RetornaX() {
		double resultado = this.baskara.delta(1, 4, 2);
		assertTrue( 8.0 == resultado );
	}
	
	class Baskara {
		public double delta(int a, int b, int c) {
			return (b * b) - (4 * a * c);
		}
	}
	
}