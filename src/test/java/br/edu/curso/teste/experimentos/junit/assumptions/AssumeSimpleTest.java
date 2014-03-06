package br.edu.curso.teste.experimentos.junit.assumptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Útil quando necessitar rodar testes  
 * <ul>
 * 		<li> para versões específicas, um cenário particular </li>
 * 		<li> que dependem de recursos de rede ou sistemas externos </li>
 * 		<li> somente em determinados locais (baseado em configurações ou arquivos) </li>
 * 		<li> somente sob determinada variável de ambiente de execução </li>
 *   	<li> restringir o espaço de solução de um determinado conjunto (quantificação com @Theory)  
 * </ul>
 */
public class AssumeSimpleTest {

	@Test
	public void testA() {
		System.out.println("hello");
		int x = 1;
		assumeThat(x, is(7));
		System.out.println("write-me pleaseeee");
	}
	
	private String versionNumber = "7"; // configuração obtida via runtime
	
	@Before	
	public void before() throws InterruptedException {
		assumeTrue(Integer.valueOf(versionNumber) == 7); // mude para valor 8
	}
	
	@Test
	public void testIfVersioonGreaterThan4() {
		System.out.println("Test executed");
	}
	
	@Test
	public void runIntegrationInDBMemory() {
		assumeThat( System.getProperty("INTEGRATION-TEST"), is("local-memory") );
		System.out.println( "rodando testes de integração local com DB memória" );
	}
	
}