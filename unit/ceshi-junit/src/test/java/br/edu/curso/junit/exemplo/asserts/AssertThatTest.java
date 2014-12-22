package br.edu.curso.junit.exemplo.asserts;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import com.google.common.collect.Lists;

public class AssertThatTest {
	
	@Test public void somaPositiva() {
		int resultado = Calculadora.soma(3, 5);
		assertThat(8, is(resultado) );
	}
	
	static class Calculadora {
		public static int soma(int a, int b) {
			return a + b;
		}
	}
	
	@Test public void enviaUnicoParametro() {
		String texto = Telegrama.envia("hello %s", "rafa");
		assertThat("hello rafa", is( texto ));
	}
	
	static class Telegrama {
		public static String envia(String template, Object ... params) {
			return String.format(template, params);
		}
	}
	
	@Test public void sorteiaNumerosCombinado() {
		List<Integer> numeros = Sorteio.sorteia();
		assertThat( numeros, hasItems( 7, 14, 34 ));
		assertThat( numeros, not(hasItems(1, 25, 51)) );
	}
	
	static class Sorteio {
		public static List<Integer> sorteia() {
			return Lists.newArrayList( 7, 14, 27, 34, 49, 51 );
		}
	}
	
	// ignorado porque propositalmente falha
	// aqui apenas para fins didáticos e entender diferença de geração de assertivas
	// descomente e observe as mensagens de erro
	@Test public void assertsDiferencaGeracoes() {
		final int CINCO = 5;
		assertTrue  ( CINCO == soma(2,3) ); 				// 1st geracao
		assertEquals( "deve ser 5", CINCO, soma(2,3) );		// 2nd geracao - voltar olhar para lembrar que é equals
		assertThat  ( "deve ser 5", soma(2,3), is(CINCO) );	// 3rd geracao : esperado fica ao lado direito!
	}
	
	private int soma(int a, int b) {
		return a + b;
	}
	
	@Test public void brincandoMatchersString() {
		String resultado = this.mensagem(); 
		
		assertThat( resultado, startsWith("123") );
		assertThat( resultado, endsWith("testando!") );
		assertThat( resultado, containsString( "oliveira" ) );
		assertThat( resultado, not( containsString( "teste" ) ) );
		
	}
	
	private String mensagem() {
		return "123 de oliveira 4, testando!";
	}
	
	@Test public void resultadoMegaSena() {
		// checar resultado em qualquer ordem 
	}
	
	@Test public void resultadoMegaSenaOrdenado() {
		// checar resultado em ordem
	}
	
	public int[] megasenaOrdenado() {
		int[] resultado = megasenaQualquerOrdem();
		Arrays.sort( resultado );
		return resultado;
	}

	public int[] megasenaQualquerOrdem() {
		return ArrayUtils.toPrimitive( new Integer[] { 7, 14, 27, 34, 49, 51 } );
	}
	
	/*
	 * vamos escrever mais alguns testes, sugetão se der tempo:
	 * 		- algarismo romano, numeros primos, etc.
	 */

}