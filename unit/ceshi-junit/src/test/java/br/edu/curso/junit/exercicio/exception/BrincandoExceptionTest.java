package br.edu.curso.junit.exercicio.exception;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BrincandoExceptionTest {
	
	@Test public void obterElementoListaVaziaTryCatch() {
		try {
			new ArrayList<Object>().get(0);			
		} catch (IndexOutOfBoundsException e) {
			// sucess
			System.out.println( e.getMessage() );
		}
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void obterElementoListaVaziaExpected() {
		new ArrayList<Object>().get(0);			
	}
	
	@Rule
	public ExpectedException exception 
		= ExpectedException.none();
	
	@Test public void obterElementoListaVaziaRule() {
		exception.expect( IndexOutOfBoundsException.class );
		exception.expectMessage( "Index: 0, Size: 0" );
		new ArrayList<Object>().get(0);		
	}

}