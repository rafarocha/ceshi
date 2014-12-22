package br.edu.curso.mockito.exercicio.verificacao.alarme;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class AlarmeTest {
	
	@Test public void soaAlarme() {
		// setup / configura
		Dispositivo dispositivoMock = mock( Dispositivo.class );
		Alarme alarme = new Alarme( dispositivoMock );
		
		// exercita
		alarme.acionar();
		
		// verifica
		verify( dispositivoMock ).emitirSinalSonoro();
	}
	
	class Alarme {
		private Dispositivo dispositivo;
		public Alarme(Dispositivo dispositivo) {
			this.dispositivo = dispositivo;
		}
		public void acionar() {
			dispositivo.emitirSinalSonoro();
		}
	}
	
	class Dispositivo {
		public void emitirSinalSonoro() {
			System.out.println( "emitindo som" );
		}
	}
	

}