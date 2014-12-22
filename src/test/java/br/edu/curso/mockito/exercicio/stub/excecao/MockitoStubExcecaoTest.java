package br.edu.curso.mockito.exercicio.stub.excecao;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings({ "unchecked" })
public class MockitoStubExcecaoTest {
	
	private Protocolo protocoloMock;
			
	@Before public void before() {
		this.protocoloMock = mock( Protocolo.class ); 
	}
	
	@Test public void stubSabotadorVoid() {
		try {
			doThrow( RuntimeException.class )
				.when( protocoloMock ).envia( anyString() );
			protocoloMock.envia( "sexta" );
			fail();
		} catch (Exception e) {
			// sucesso
		}
	}
	
	@Test
	public void stubSabotador() {
		try {
			// instala
			when( protocoloMock.gera( anyString() ) )
				.thenThrow( RuntimeException.class );
			// exercita
			protocoloMock.gera( "sexta" );
			
			// defesa
			fail();
		} catch (Exception e) {
			// sucesso
		}
	}
	
	class Protocolo {
		public void envia(String numero) {
			System.out.println( this.gera(numero) );
		}
		public String gera(String numero) {
			return String.format("numero #", numero);
		}
	}

}