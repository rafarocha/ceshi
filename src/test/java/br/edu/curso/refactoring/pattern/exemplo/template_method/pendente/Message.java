package br.edu.curso.refactoring.pattern.exemplo.template_method.pendente;

public interface Message {
	
	String PAGAMENTO = "pagamento boleto n.%s".concat( Temp.sufix ); 
	String TRANSFERENCIA = "transfer�ncia para conta %s".concat( Temp.sufix );

	interface Temp {
		String sufix = " no total de %s";
	}
	
}