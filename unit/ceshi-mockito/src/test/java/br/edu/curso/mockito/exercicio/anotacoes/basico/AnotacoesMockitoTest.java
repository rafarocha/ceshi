package br.edu.curso.mockito.exercicio.anotacoes.basico;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.curso.mockito.exercicio.anotacoes.basico.Maquina.Motor;

@RunWith(MockitoJUnitRunner.class)
public class AnotacoesMockitoTest {
	
	@Mock private Motor motorMock;
	@InjectMocks private Maquina maquina;
	
	@Test public void ligarSucesso() {
		maquina.ligar();
		verify( motorMock ).acionar();
	}

}