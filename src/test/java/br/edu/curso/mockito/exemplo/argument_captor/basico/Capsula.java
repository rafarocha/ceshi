package br.edu.curso.mockito.exemplo.argument_captor.basico;

public class Capsula {
	
	public Sabor sabor;
	
	public Capsula(Sabor sabor) {
		this.sabor = sabor;
	}
		
	public enum Sabor {
		Chocolate, Capuccino, Tradicional;
	}

}