package br.edu.curso.junit.exemplo.rules;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class RuleTestTimeout {

	private static final int CENTESIMO_SEGUNDO = 100;

	@Rule
	public TestRule globalTimeout = new Timeout( CENTESIMO_SEGUNDO ); // por exemplo nenhum teste deve exceder 1 seg
	
	@Test @Ignore // comente o ignore para fazer o teste falhar 
	public void throwsExcp() throws InterruptedException {
		try {
			Thread.sleep(101);
			System.out.println( "ops, n�o vai imprimir isto" );
		} catch (Throwable e) {
			System.out.println( "vai imprimir isto" );
		}
		System.out.println( "e isto tamb�m, mas, por que o m�todo falha?" );
	}

}