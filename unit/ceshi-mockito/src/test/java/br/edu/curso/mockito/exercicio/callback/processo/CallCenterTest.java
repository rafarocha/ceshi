package br.edu.curso.mockito.exercicio.callback.processo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import br.edu.curso.mockito.exercicio.callback.processo.Atendimento.Atendente;
import br.edu.curso.mockito.exercicio.callback.processo.Atendimento.Auditoria;
import br.edu.curso.mockito.exercicio.callback.processo.Cliente.Nota;
import br.edu.curso.mockito.exercicio.callback.processo.Cliente.Servico;

public class CallCenterTest {
	
	private Atendente atendenteMock;
	private Auditoria auditoriaMock;
	
	private Cliente cliente;
	private Protocolo protocolo;
	private CallCenter callcenter;
	
	@Before public void before() {
		// mocks
		this.atendenteMock = mock( Atendente.class );
		this.auditoriaMock = mock( Auditoria.class );
		
		// real
		this.configurarDominio();
	}
	
	@Test public void malSucedido() {
		when( atendenteMock.atender( any(Cliente.class) ))
			.thenReturn( protocolo );
		
		doAnswer( new AnswerAtendimento() )
			.when( auditoriaMock )
			.registrar( any(Atendimento.class) );
		
		this.callcenter.atender( cliente );
				
		verify( atendenteMock ).atender( cliente );
		verify( auditoriaMock ).registrar( any(Atendimento.class) );		
	}
	
	class AnswerAtendimento implements Answer<Atendimento> {
		public Atendimento answer(InvocationOnMock invocation) throws Throwable {
			Atendimento atendimento = this.getAtendimento( invocation );
			assertEquals( atendimento.nota, Nota.Pessimo);
			assertTrue  ( atendimento.acompanhamento );
			assertThat  ( atendimento.protocolo, is(protocolo ) );
			return atendimento;
		}
		private Atendimento getAtendimento(InvocationOnMock in) {
			return (Atendimento) in.getArguments()[0];
		}
	}
	
	private void configurarDominio() {
		this.callcenter = CallCenter.builder()
				.atendente( this.atendenteMock )
				.auditoria( this.auditoriaMock )
				.build();
		
		this.cliente = new Cliente( "Bob Marley", Servico.Cancelar ); 

		this.protocolo = Protocolo.builder()
				.cliente( this.cliente.id )
				.data( new Date() )
				.build();
	}
	
}