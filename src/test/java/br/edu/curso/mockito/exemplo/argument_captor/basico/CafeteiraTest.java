package br.edu.curso.mockito.exemplo.argument_captor.basico;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.curso.mockito.exemplo.argument_captor.basico.Capsula.Sabor;

@RunWith(MockitoJUnitRunner.class)
public class CafeteiraTest {
	
	@Captor ArgumentCaptor<Capsula> argCapsula;
	@InjectMocks Cafeteira cafeteira;
	@Mock Modulo moduloMock;
	
	@Test public void prepararCapuccino() {		
		cafeteira.preparar( Sabor.Capuccino );
		verify( moduloMock ).preparar( argCapsula.capture() );
		
//		ArgumentCaptor<Capsula> argument = ArgumentCaptor.forClass(Capsula.class);		
		System.out.println( "sabor " + argCapsula.getValue().sabor );
	}
	
}