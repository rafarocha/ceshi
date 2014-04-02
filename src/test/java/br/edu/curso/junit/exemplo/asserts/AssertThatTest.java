package br.edu.curso.junit.exemplo.asserts;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;

public class AssertThatTest {
	
	@Test public void somaPositiva() {
		int resultado = Calculadora.soma(3, 5);
		assertThat(8, is(resultado));
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
		assertThat( numeros, hasItems( 7, 14, 27 ));
		assertThat( numeros, not( hasItems( 1, 25, 51 )) );
	}
	
	static class Sorteio {
		public static List<Integer> sorteia() {
			return Lists.newArrayList( 7, 14, 27, 34, 49, 51 );
		}
	}
	
	// ignorado porque propositalmente falha
	// aqui apenas para fins didáticos e entender diferença de geração de assertivas
	// descomente e observe as mensagens de erro
	@Test @Ignore public void assertsDiferencaGeracoes() {
		assertTrue( 5 == 7 ); 	// 1st geracao
		assertEquals( 5, 7 );	// 2nd geracao
		assertThat( 5, is(7) );	// 3rd geracao
	}
	
	/*
	 * vamos escrever mais alguns testes, sugetões:
	 * - bingo, dado, par ou impar, algarismo romano, etc.
	 */

}