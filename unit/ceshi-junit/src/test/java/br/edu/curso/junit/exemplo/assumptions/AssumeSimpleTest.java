package br.edu.curso.junit.exemplo.assumptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * �til quando necessitar rodar testes  
 * <ul>
 * 		<li> para vers�es espec�ficas, um cen�rio particular </li>
 * 		<li> que dependem de recursos de rede ou sistemas externos </li>
 * 		<li> somente em determinados locais (baseado em configura��es ou arquivos) </li>
 * 		<li> somente sob determinada vari�vel de ambiente de execu��o </li>
 *   	<li> restringir o espa�o de solu��o de um determinado conjunto (quantifica��o com @Theory)  
 * </ul>
 */
public class AssumeSimpleTest {

	@Test
	public void testA() {
		System.out.println("hello");
		int x = 1;
		assumeThat(x, is(7));
		// aqui
		System.out.println("write-me pleaseeee");
	}
	
	private String versionNumber = "7"; // configuracao obtida via runtime
	
	@Before	
	public void before() throws InterruptedException {
		assumeTrue(Integer.valueOf(versionNumber) == 9); // mude para valor 8
//		System.setProperty("INTEGRATION-TEST", "local-memory");
	}
	
	@Test
	public void testIfVersioonGreaterThan4() {
		System.out.println("Test executed");
	}
	
	@Test
	public void runIntegrationInDBMemory() {
		assumeThat( System.getProperty("INTEGRATION-TEST"), is("local-memory") );
		System.out.println( "rodando testes de integracao local com DB memoria" );
	}
	
}