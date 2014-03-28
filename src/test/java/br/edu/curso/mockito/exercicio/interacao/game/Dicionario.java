package br.edu.curso.mockito.exercicio.interacao.game;

import java.io.IOException;
import java.util.Random;

import br.edu.curso.util.Util;

public class Dicionario {
	
	enum Tema {
		animais
	}
	
	String eleger(Tema tema) {
		String content = getConteudo( tema );
		return sortear( content );
	}
	
	private String sortear(String conteudo) {
		String[] palavras = conteudo.split("\n");
		int index = new Random().nextInt( palavras.length );
		return palavras[index];
	}

	private String getConteudo(Tema tema) {
		try {
			return Util.carregarArquivo( Dicionario.class, tema.toString() );
		} catch (IOException e) {
			throw new IllegalStateException("arquivo nao existe");
		}
	}

}