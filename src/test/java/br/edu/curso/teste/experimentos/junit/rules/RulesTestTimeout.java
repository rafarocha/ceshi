package br.edu.curso.teste.experimentos.junit.rules;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class RulesTestTimeout {

	private static final int UM_SEGUNDO = 100;

	@Rule
	public TestRule globalTimeout = new Timeout( UM_SEGUNDO ); // por exemplo nenhum teste deve exceder 1 seg
	
	@Test @Ignore // comente o ignore para fazer o teste falhar 
	public void throwsExcp() throws InterruptedException {
		try {
			Thread.sleep(101);
			System.out.println( "ops, não vai imprimir isto" );
		} catch (Throwable e) {
			System.out.println( "vai imprimir isto" );
		}
		System.out.println( "e isto também, mas, por que o método falha?" );
	}

}