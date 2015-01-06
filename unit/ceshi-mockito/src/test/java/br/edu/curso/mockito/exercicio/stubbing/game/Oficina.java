package br.edu.curso.mockito.exercicio.stubbing.game;

public class Oficina {
	
	public static Jogador jogador(String nome, final String mapa, final String palpite) {
		return new Jogador(nome, "", new Configuracao() {
			public void configurar() {
				this.configurar( mapa );
				this.palpitar( palpite.split("-") );
			}
		});		
	}

}