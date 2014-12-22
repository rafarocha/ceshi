package br.edu.curso.mockito.exercicio.matchers_args.correios;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.edu.curso.mockito.exercicio.matchers_args.correios.Telegrama.Despachador;
import br.edu.curso.mockito.exercicio.matchers_args.correios.Telegrama.Funcionario;

public class AgenciaTest {
	
	private Agencia agencia;
	
	private Inspetoria inspetorMock;
	private Despachador despachadorMock;
	private Funcionario funcionarioMock;
	
	@Before public void before() {
		// mocks
		this.inspetorMock  = mock( Inspetoria.class );
		this.despachadorMock = mock( Despachador.class );
		this.funcionarioMock = mock( Funcionario.class );
		
		// real
		this.agencia = new Agencia(funcionarioMock, despachadorMock, inspetorMock);
	}
	
	private static final String texto 
			= "vamos aumentar o preço do barril de petróleo no 3rd trimestre";
	
	@Test public void enviar() {
		Telegrama telegrama = new Telegrama( texto, new Date() );		
		
		when( funcionarioMock.preparar(
				anyString(), any(Date.class), any(Envelope.class) )
			).thenReturn( telegrama );
				
		agencia.enviar( texto, new Date(), null );
		
		verify( inspetorMock ).validar( telegrama );
		verify( despachadorMock ).entregar( telegrama );
	}
	
}