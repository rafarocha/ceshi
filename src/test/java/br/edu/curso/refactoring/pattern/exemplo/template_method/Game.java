package br.edu.curso.refactoring.pattern.exemplo.template_method;

/**
 * Apenas para fins did�ticos de ilustrar um exemplo de uso do padr�o
 * Existe um exemplo para melhorar o reuso dos asserts para simplificar e diminuir o tamanho da hist�ria do teste
 * http://en.wikipedia.org/wiki/Template_method_pattern
 */
public abstract class Game {

	protected int playersCount;
    
	abstract void initializeGame();
    abstract void makePlay(int player);
    abstract boolean endOfGame();
    abstract void printWinner();
 
    /* A template method : */
    public final void playOneGame(int playersCount) {
        this.playersCount = playersCount;
        initializeGame();
        int j = 0;
        while (!endOfGame()) {
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }
	
}