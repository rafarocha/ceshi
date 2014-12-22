package br.edu.curso.mockito.exercicio.stubbing.desafio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StubbingDoReturnTest {
	
	// modifique o teste para fazer stubbing com doReturn 
	@Test public void obterPrimeiro() {
		List<String> lista = mock( List.class );
		
		doReturn( "hello" ).when( lista ).get( 0 );
		when( lista.get(0) ).thenReturn( "hello" );
		
		assertThat( "hello" , is( lista.get(0) ));
	}
	
	@Test public void obterPrimeiroSpy() {
		List<String> listaReal = new ArrayList<String>();
		List<String> listaSpy = spy( listaReal );
		
		doReturn( "hello" ).when( listaSpy ).get( 0 );
		
		assertThat( "hello" , is( listaSpy.get(0) ));		
	}
	
}