package br.edu.curso.mockito.exercicio.stubbing.filme;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import br.edu.curso.mockito.exercicio.stubbing.filme.Personagem.Ator;
import br.edu.curso.mockito.exercicio.stubbing.filme.Personagem.Atriz;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Cena {
	
	private Ator ator;
	private Atriz atriz;
	
	void acao() {
		Personagem sapo = ator.interpreta();
		Personagem princesa = atriz.interpreta();
		princesa.beija( sapo );
	}
	
}