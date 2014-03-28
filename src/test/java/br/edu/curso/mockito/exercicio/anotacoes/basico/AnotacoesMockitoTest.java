package br.edu.curso.mockito.exercicio.anotacoes.basico;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import br.edu.curso.mockito.exercicio.anotacoes.basico.Maquina.Motor;

public class AnotacoesMockitoTest {
	
	private Maquina maquina;
	private Motor motor;
	
	@Before public void before() {
		this.motor = mock( Motor.class ); // remova esta linha e faça modificações necessárias
		this.maquina = new Maquina( this.motor );
	}
	
	@Test public void ligarSucesso() {
		maquina.ligar();
		verify( motor ).acionar();
	}

}