package br.edu.curso.mockito.exercicio.matchers_args.correios;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class DesafioTest {
	
	public static final int[] posicoes = new int[] {
		0, -1, 10, 99, 999, Integer.MAX_VALUE
	};
	
	@Test @Ignore public void desafio() {
		String texto = "sucesso";
		List<String> lista = null;
		for (int index : posicoes) {
			assertThat( lista.get(index), org.hamcrest.Matchers.is(texto) );
			this.imprime( lista, index, texto );
		}
	}
	
	private void imprime(List<String> lista, int index, String texto) {
		String mensagem = "lista(%s) \t\t '%s' .equals '%s' ";
		System.out.println( String.format(mensagem, index, lista.get(index), texto) );
	}

}