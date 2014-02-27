package br.edu.curso.teste.experimentos.refactoring.pattern.template_method;

public class Chess extends Game {

	@Override void initializeGame() {}
	@Override void makePlay(int player) {}
	@Override void printWinner() {}
	@Override boolean endOfGame() { return false; }

}