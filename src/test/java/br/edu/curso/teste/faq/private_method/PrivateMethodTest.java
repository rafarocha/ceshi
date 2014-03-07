package br.edu.curso.teste.faq.private_method;

import org.junit.Test;

public class PrivateMethodTest {
	
	@Test public void condition1() {
		// metodo publico if true
	}
	
	@Test public void condition2() {
		// metodo publico if true >>> metodo privado if true
	}
	
	@Test public void condition3() {
		// metodo publico if true >>> metodo privado if false
	}

}