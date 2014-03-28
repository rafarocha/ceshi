package br.edu.curso.mockito.exercicio.interacao.game;

import java.util.Scanner;

public class Coletor {
	
	private Scanner scanner;

	public Coletor() {
		this.scanner = new Scanner( System.in );
	}
	
	public String obter() {
		return scanner.next();
	}
	

}