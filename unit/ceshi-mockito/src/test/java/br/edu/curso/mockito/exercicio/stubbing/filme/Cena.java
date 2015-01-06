package br.edu.curso.mockito.exercicio.stubbing.filme;

import br.edu.curso.mockito.exercicio.stubbing.filme.Personagem.Ator;
import br.edu.curso.mockito.exercicio.stubbing.filme.Personagem.Atriz;

public class Cena {
	
	public Cena(Ator ator, Atriz atriz) {
		this.ator = ator;
		this.atriz = atriz;
	}
	
	private Ator ator;
	private Atriz atriz;
	
	void acao() {
		Personagem sapo = ator.interpreta();
		Personagem princesa = atriz.interpreta();
		princesa.beija( sapo );
	}
	
}