package br.edu.curso.junit.faq.falso_positivo;

import org.junit.Test;

public class PatoTest {
	
	@Test public void andarSemPatas() {
		try {
			Pato pato = new Pato();
			pato.andar();
		} catch (IllegalStateException e) {
			// sucess
		}
	}
	
	class Pato {
		private Pata esquerda;
		private Pata direita;
		
		public void andar() {
			if ( esquerda == null || direita == null )
				 throw new IllegalStateException();
		}
	}
	
	class Pata{}

}