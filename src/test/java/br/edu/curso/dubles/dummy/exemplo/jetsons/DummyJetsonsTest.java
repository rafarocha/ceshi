package br.edu.curso.dubles.dummy.exemplo.jetsons;

import static com.natpryce.makeiteasy.MakeItEasy.make;

import org.junit.Test;

import br.edu.curso.dubles.dummy.exemplo.jetsons.Objeto.Nave;

public class DummyJetsonsTest {
	
	@Test public void lavarAeronave() {
		Jetson george = make( JetsonsBuilder.makerGeorge );
		george.lavar( new DummyNave() );
		// mecanismo que verifica se rosie mandou lavar
	}
	
	private class DummyNave implements Nave {
		public int getAltimeter() {
			throw new IllegalStateException();
		}
		public int getVariometer() {
			throw new IllegalStateException();
		}
	}
	
}