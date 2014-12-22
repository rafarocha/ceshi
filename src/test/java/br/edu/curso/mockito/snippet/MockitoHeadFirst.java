package br.edu.curso.mockito.snippet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class MockitoHeadFirst {
	
	@Test public void verificandoInteracoes() {
		List<String> listaMock = mock( List.class );
		listaMock.add( "one" );
		listaMock.clear();
		
		verify( listaMock ).add( "one" );
		verify( listaMock ).clear();
	}
	
	@Test public void stubbingMetodos() {
		List<String> listaMock = mock( List.class );
		when( listaMock.get(0) ).thenReturn( "first" );
		
		
		System.out.println( listaMock.get(0) );
		System.out.println( listaMock.get(999) );
	}

}