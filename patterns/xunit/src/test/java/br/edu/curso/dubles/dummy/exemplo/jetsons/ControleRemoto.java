package br.edu.curso.dubles.dummy.exemplo.jetsons;

import br.edu.curso.dubles.dummy.exemplo.jetsons.Objeto.Nave;

public class ControleRemoto {
	
	public Robo robo;
	
	public ControleRemoto(Robo robo) {
		this.robo = robo;
	}

	public Robo ir(Local local) {
		robo.walk( local );
		return robo;
	}

	public void lavar(Nave nave) {
		System.out.println( "chama empresa responsavel por limpeza para lavar carro" );
	}

}