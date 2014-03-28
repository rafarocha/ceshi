package br.edu.curso.mockito.exercicio.interacao.game;

import java.io.IOException;

import br.edu.curso.util.Util;

public class Desenhista {
	
	public void desenha(int erros) {
		System.out.println( ascii(erros) );
	}
	
	private String ascii(int erros) {
		try {
			return Util.carregarArquivo( Desenhista.class, "ascii" + erros );
		} catch (IOException e) {
			throw new IllegalStateException("arquivo nao existe");
		}
	}
	
}