package br.edu.curso.mockito.exemplo.callback;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class CalculoTest {
	
	@Test public void areaAnswerClasseInternaAnonima() {
		Triangulo calculoMock = mock(Triangulo.class);
		
		when( calculoMock.area( anyInt(), anyInt(), anyInt() ))
			.thenAnswer(new Answer<String>() {
				String msg = "mock <%s> foi chamado com argumentos: %s e o resultado foi %s ";
				public String answer(InvocationOnMock invocation) throws Throwable {
					Object[] args = invocation.getArguments();
			        Object mock = invocation.getMock();
			        Object real = invocation.callRealMethod();
			        
			        String values = ArrayUtils.toString( args );
			        return String.format(msg, mock, values, real);
	
				}
			});
		System.out.println(calculoMock.area(1,2,3));
	}
	
	@Test public void areaAnswerClasseConcreta() {
		Triangulo calculoMock = mock(Triangulo.class);
		
		when( calculoMock.area( anyInt(), anyInt(), anyInt() ))
			.thenAnswer( new AnswerTriangulo() );
		
		System.out.println(calculoMock.area(1,2,3));
	}
	
	class Triangulo {
		public String area(int a, int b, int c) {
			return String.format("a=%s : b=%s : c%s", a, b, c);
		}
	}
	
	// implementação foi propositalmente copiada do teste areaAnswerClasseInternaAnonima :)
	class AnswerTriangulo implements Answer<String> {
		String msg = "mock <%s> foi chamado com argumentos: %s e o resultado foi %s ";
		public String answer(InvocationOnMock invocation) throws Throwable {
			Object[] args = invocation.getArguments();
	        Object mock = invocation.getMock();
	        Object real = invocation.callRealMethod();
	        
	        String values = ArrayUtils.toString( args );
	        return String.format(msg, mock, values, real);

		}
	}

}