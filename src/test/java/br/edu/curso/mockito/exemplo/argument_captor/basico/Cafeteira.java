package br.edu.curso.mockito.exemplo.argument_captor.basico;

import br.edu.curso.mockito.exemplo.argument_captor.basico.Capsula.Sabor;

public class Cafeteira {
	
	private Modulo modulo;
	
	public Cafeteira(Modulo modulo) {
		this.modulo = modulo;
	}
	
	public void preparar(Sabor sabor) {
		modulo.preparar( new Capsula(sabor) );
	}

}