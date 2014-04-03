package br.edu.curso.faq.falso_positivo;

import org.junit.Test;

/**
 * crie um novo caso em que o pato possui apenas a pata esquerda
 */
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
			System.out.println( "fazer o pato andar" );
		}
	}
	
	class Pata {}

}