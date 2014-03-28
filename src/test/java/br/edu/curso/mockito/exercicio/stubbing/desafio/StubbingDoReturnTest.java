package br.edu.curso.mockito.exercicio.stubbing.desafio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class StubbingDoReturnTest {
	
	// modifique o teste para fazer stubbing com doReturn 
	@Test @Ignore public void obterPrimeiro() {
		List<String> lista = mock( List.class );
		
		when( lista.get( anyInt() ) ).thenReturn( "hello" );
		when( lista.get( 0 ) ).thenReturn( "hello" ); // por que esta forma funciona?
		doReturn( anyInt() ).when( lista ).get( 0 );
		
		assertThat( "hello" , is( lista.get(0) ));
	}
	
}