package br.edu.curso.mockito.exercicio.stubbing.filme;

import com.google.common.base.Preconditions;

public class Personagem {
	
	public void beija(Personagem sapo) {
		Preconditions.checkNotNull( sapo );
		System.out.println( "feitiço quebrado :)" );
	}
	
	class Ator {
		public Personagem interpreta() {
			return null;
		}
	}
	
	class Atriz {
		public Personagem interpreta() {
			return null;
		}
	}

}