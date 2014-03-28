package br.edu.curso.mockito.exemplo.argument_captor.basico;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import br.edu.curso.mockito.exemplo.argument_captor.basico.Capsula.Sabor;

public class CafeteiraTest {
	
	@Test public void prepararCapuccino() {
		Modulo moduloMock = mock( Modulo.class );
		Cafeteira cafeteira = new Cafeteira( moduloMock );
		
		cafeteira.preparar( Sabor.Capuccino );
		
		ArgumentCaptor<Capsula> argument = ArgumentCaptor.forClass(Capsula.class);
		verify( moduloMock ).preparar( argument.capture() );
		System.out.println( "sabor " + argument.getValue().sabor );
	}
	
}