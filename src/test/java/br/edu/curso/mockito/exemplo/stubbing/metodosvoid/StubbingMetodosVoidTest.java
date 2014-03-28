package br.edu.curso.mockito.exemplo.stubbing.metodosvoid;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class StubbingMetodosVoidTest {
	
	@Test public void doReturnComMetodoVoid_Ops() {
		try {
			List<String> listaMock = mock( List.class );
			Mockito.doReturn( new Object() ).when( listaMock ).clear();
			fail();
		} catch (Throwable e) {
			System.out.println( e );
		}
	}
	
	// podemos fazer stubbing com seus parâmetros usando answer com doAnswer() 
	// mas ... veremos adiante

}