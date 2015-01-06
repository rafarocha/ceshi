package br.edu.curso.mockito.exemplo.callback.basico;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorTest {
	
	@InjectMocks Professor professor;
	@Mock Aluno alunoMock;
	
	@Test public void emiteMensagem() {
		doAnswer( new AnswerMensagem() )
			.when( alunoMock )
			.recebe( any(Mensagem.class) ); 
		
		professor.emitir();
		verify( alunoMock ).recebe( any(Mensagem.class) );
	}
	
	class AnswerMensagem implements Answer<Mensagem> {
		@Override
		public Mensagem answer(InvocationOnMock invocation) throws Throwable {
			Mensagem mensagem = (Mensagem) invocation.getArguments()[0];
			assertThat( "muito", is(mensagem.x) );
			assertThat( "obrigado!", is(mensagem.y) );
			return null;
		}
		
	}

}