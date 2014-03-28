package br.edu.curso.mockito.exemplo.argument_captor.fundamental;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CifraCesarTest {
	
	private @Mock Pombo pomboMock;
	private @InjectMocks Mensageiro mensageiro;
	
	private @Captor ArgumentCaptor<String> argumento;
	
	@Test public void pomboEnviaMensagemAtaqueCrifrada() {
		String comando = "atacaaaaar!!!";
		mensageiro.enviar( comando );
		verify( pomboMock ).enviar( argumento.capture() );
		
		String comandoCifrado = mensageiro.cifra(comando);
		assertThat( argumento.getValue(), Matchers.containsString(comandoCifrado) );
		
		imprime( comando );
	}

	private void imprime(String comando) {
		System.out.println( "comando \t\t" + argumento.getValue() );
		System.out.println( "comando cifrado \t" + mensageiro.cifra(comando) );
		
		String comandoCifrado = argumento.getValue().split(":")[1];
		System.out.println( "comando decifrado\t" + mensageiro.decifra(comandoCifrado) );
	}
	
	interface Pombo {
		String enviar(String matricula);
	}

}