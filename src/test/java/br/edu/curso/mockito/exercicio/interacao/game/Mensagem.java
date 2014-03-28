package br.edu.curso.mockito.exercicio.interacao.game;

public interface Mensagem {
	
	String winner = "\n\nparabéns \\o/ acertou a palavra %s em %s tentativa(s) ";
	String looser = "\n\nforca /o\\ ... a palavra era %s \n%s tentativas total";
	
	String[] welcome = { "\u250C\u2500\u2500\u2500\u2500\u2500\u2510",
			"\u2502Forca\u2502",
			"\u2514\u2500\u2500\u2500\u2500\u2500\u2518" };
	
	String regra = "regra: são 6 chances de erro, sem repetições!";
	String dica  = "dica : O tema é %s e a palavra tem %s letras";
	
	String mostraErros = " %s : %s erro(s) = %s";
	
	String perigo = "\n\nP E R I G O : Mais uma tentativa apenas, pense bem!";

}