package br.edu.curso.teste.refactoring.pattern.templatemethod;

public interface Message {
	
	String PAGAMENTO = "pagamento boleto n.%s".concat( Temp.sufix ); 
	String TRANSFERENCIA = "transferência para conta %s".concat( Temp.sufix );

	interface Temp {
		String sufix = " no total de %s";
	}
	
}