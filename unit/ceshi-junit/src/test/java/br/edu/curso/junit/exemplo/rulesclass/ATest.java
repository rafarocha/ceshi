package br.edu.curso.junit.exemplo.rulesclass;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

import org.junit.Before;
import org.junit.Test;

public class ATest {
	
	@Before public void before() {
		assumeThat( true, is(ClassRulesTestExternalResource.myServer.isRunning()) );
	}
	
	@Test public void helloTest() {
		// se rodar por aqui nao irei executar. serei ignorado devido ao before
		// tente executar a classe ClassRulesTestExternalResource
		System.out.println( "entendeu?" );
	}

}