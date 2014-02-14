package com.rocha.curso.ceshi.refactoring.pattern.templatemethod;

public interface Message {
	
	String PAGAMENTO = "pagamento %s realizado".concat( Temp.sufix ); 
	String MULTA = "multa %s paga".concat( Temp.sufix );
	String REEMBOLSO = "reembolso %s efetuado".concat( Temp.sufix );

	interface Temp {
		String sufix = " no valor de %d";
	}
	
}

