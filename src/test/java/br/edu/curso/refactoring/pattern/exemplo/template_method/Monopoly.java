package br.edu.curso.refactoring.pattern.exemplo.template_method;

public class Monopoly extends Game {
	
	@Override void initializeGame() {}
	@Override void makePlay(int player) {}
	@Override void printWinner() {}
	@Override boolean endOfGame() { return false; }
	
}